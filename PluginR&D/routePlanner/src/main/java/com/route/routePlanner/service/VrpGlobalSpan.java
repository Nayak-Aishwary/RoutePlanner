package com.route.routePlanner.service;

import java.util.Arrays;
import java.util.LinkedList;

import com.route.routePlanner.form.LocationBean;

/** Minimal VRP. */
public class VrpGlobalSpan {
//	static {
//		System.loadLibrary("jniortools");
//	}

//	private static final Logger logger = Logger.getLogger(VrpGlobalSpan.class.getName());

//	static class DataModel {
//		public final long[][] distanceMatrix = {
//				{ 0, 548, 776, 696, 582, 274, 502, 194, 308, 194, 536, 502, 388, 354, 468, 776, 662 },
//				{ 548, 0, 684, 308, 194, 502, 730, 354, 696, 742, 1084, 594, 480, 674, 1016, 868, 1210 },
//				{ 776, 684, 0, 992, 878, 502, 274, 810, 468, 742, 400, 1278, 1164, 1130, 788, 1552, 754 },
//				{ 696, 308, 992, 0, 114, 650, 878, 502, 844, 890, 1232, 514, 628, 822, 1164, 560, 1358 },
//				{ 582, 194, 878, 114, 0, 536, 764, 388, 730, 776, 1118, 400, 514, 708, 1050, 674, 1244 },
//				{ 274, 502, 502, 650, 536, 0, 228, 308, 194, 240, 582, 776, 662, 628, 514, 1050, 708 },
//				{ 502, 730, 274, 878, 764, 228, 0, 536, 194, 468, 354, 1004, 890, 856, 514, 1278, 480 },
//				{ 194, 354, 810, 502, 388, 308, 536, 0, 342, 388, 730, 468, 354, 320, 662, 742, 856 },
//				{ 308, 696, 468, 844, 730, 194, 194, 342, 0, 274, 388, 810, 696, 662, 320, 1084, 514 },
//				{ 194, 742, 742, 890, 776, 240, 468, 388, 274, 0, 342, 536, 422, 388, 274, 810, 468 },
//				{ 536, 1084, 400, 1232, 1118, 582, 354, 730, 388, 342, 0, 878, 764, 730, 388, 1152, 354 },
//				{ 502, 594, 1278, 514, 400, 776, 1004, 468, 810, 536, 878, 0, 114, 308, 650, 274, 844 },
//				{ 388, 480, 1164, 628, 514, 662, 890, 354, 696, 422, 764, 114, 0, 194, 536, 388, 730 },
//				{ 354, 674, 1130, 822, 708, 628, 856, 320, 662, 388, 730, 308, 194, 0, 342, 422, 536 },
//				{ 468, 1016, 788, 1164, 1050, 514, 514, 662, 320, 274, 388, 650, 536, 342, 0, 764, 194 },
//				{ 776, 868, 1552, 560, 674, 1050, 1278, 742, 1084, 810, 1152, 274, 388, 422, 764, 0, 798 },
//				{ 662, 1210, 754, 1358, 1244, 708, 480, 856, 514, 468, 354, 844, 730, 536, 194, 798, 0 }, };
//		public final int vehicleNumber = 4;
//		public final int depot = 0;
//	}

	private static void calculateDistance(LinkedList<LocationBean> locationBeanList) {

		int inputSize = locationBeanList.size();
		double[][] distanceMatrix = new double[inputSize][inputSize];
		for (int i = 0; i < locationBeanList.size(); i++) {
			int count = 0;
			LocationBean locationBean1 = locationBeanList.get(i);
			LinkedList<Double> distanceMatrixEntry = new LinkedList<>();
			for (int j = 0; j < locationBeanList.size(); j++) {
				LocationBean locationBean2 = locationBeanList.get(j);
				double distance = Math.abs(locationBean2.getLatitude() - locationBean1.getLatitude())
						+ Math.abs(locationBean2.getLongitude() - locationBean1.getLongitude());
				distance = distance * 6371;
				distanceMatrixEntry.add(distance);
				distanceMatrix[i][count] = distance;
				count++;
			}
			locationBean1.setDistanceMatrixEntry(distanceMatrixEntry);
		}
		System.out.println(Arrays.deepToString(distanceMatrix));
	}

	public static void main(String[] args) throws Exception {
		LinkedList<LocationBean> locationBeanList = new LinkedList<>();
		LocationBean l1 = new LocationBean();
		l1.setLatitude(Math.toRadians(18.6151));
		l1.setLongitude(Math.toRadians(73.765693));
		LocationBean l2 = new LocationBean();
		l2.setLatitude(Math.toRadians(18.5809));
		l2.setLongitude(Math.toRadians(73.6879));
		LocationBean l3 = new LocationBean();
		l3.setLatitude(Math.toRadians(18.5793));
		l3.setLongitude(Math.toRadians(73.9089));
		LocationBean l4 = new LocationBean();
		l4.setLatitude(Math.toRadians(18.5951));
		l4.setLongitude(Math.toRadians(73.7887));
		LocationBean l5 = new LocationBean();
		l5.setLatitude(Math.toRadians(18.7053));
		l5.setLongitude(Math.toRadians(73.7916));
		locationBeanList.add(l1);
		locationBeanList.add(l2);
		locationBeanList.add(l3);
		locationBeanList.add(l4);
		locationBeanList.add(l5);
		calculateDistance(locationBeanList);
	}
}