package com.route.routePlanner.service;

import org.springframework.stereotype.Service;

import com.google.ortools.constraintsolver.Assignment;
import com.google.ortools.constraintsolver.FirstSolutionStrategy;
import com.google.ortools.constraintsolver.RoutingDimension;
import com.google.ortools.constraintsolver.RoutingIndexManager;
import com.google.ortools.constraintsolver.RoutingModel;
import com.google.ortools.constraintsolver.RoutingSearchParameters;
import com.google.ortools.constraintsolver.main;
import com.route.routePlanner.form.InputForm;

@Service
public class ProcessService {

	public void processInput(InputForm inputForm) throws Exception {
		// Instantiate the data problem.
//		final DataModel data = new DataModel();

		long[][] distanceMatrix = inputForm.getDistanceMatrix();
		int vehicleNumber = inputForm.getVehicleNumber();
		int depotIndex = inputForm.getDepotIndex();

		// Create Routing Index Manager
		RoutingIndexManager manager = new RoutingIndexManager(distanceMatrix.length, vehicleNumber, depotIndex);

		// Create Routing Model.
		RoutingModel routing = new RoutingModel(manager);

		// Create and register a transit callback.
		final int transitCallbackIndex = routing.registerTransitCallback((long fromIndex, long toIndex) -> {
			// Convert from routing variable Index to user NodeIndex.
			int fromNode = manager.indexToNode(fromIndex);
			int toNode = manager.indexToNode(toIndex);
			return distanceMatrix[fromNode][toNode];
		});

		// Define cost of each arc.
		routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);

		// Add Distance constraint.
		routing.addDimension(transitCallbackIndex, 0, 3000, true, // start cumul to zero
				"Distance");
		RoutingDimension distanceDimension = routing.getMutableDimension("Distance");
		distanceDimension.setGlobalSpanCostCoefficient(100);

		// Setting first solution heuristic.
		RoutingSearchParameters searchParameters = main.defaultRoutingSearchParameters().toBuilder()
				.setFirstSolutionStrategy(FirstSolutionStrategy.Value.PATH_CHEAPEST_ARC).build();

		// Solve the problem.
		Assignment solution = routing.solveWithParameters(searchParameters);

		// Print solution on console.
		printSolution(inputForm, routing, manager, solution);
	}

	static void printSolution(InputForm inputForm, RoutingModel routing, RoutingIndexManager manager,
			Assignment solution) {

		// Inspect solution.
		long maxRouteDistance = 0;
		for (int i = 0; i < inputForm.getVehicleNumber(); ++i) {
			long index = routing.start(i);
//			logger.info("Route for Vehicle " + i + ":");
			System.out.println("Route for Vehicle " + i + "");
			long routeDistance = 0;
			String route = "";
			while (!routing.isEnd(index)) {
				route += manager.indexToNode(index) + " -> ";
				long previousIndex = index;
				index = solution.value(routing.nextVar(index));
				routeDistance += routing.getArcCostForVehicle(previousIndex, index, i);
			}
//			logger.info(route + manager.indexToNode(index));
			System.out.println((route + manager.indexToNode(index)));
//			logger.info("Distance of the route: " + routeDistance + "m");
			System.out.println("Distance of the route: " + routeDistance + "m");
			maxRouteDistance = Math.max(routeDistance, maxRouteDistance);
		}
//		logger.info("Maximum of the route distances: " + maxRouteDistance + "m");
		System.out.println("Maximum of the route distances: " + maxRouteDistance + "m");
	}

}
