package com.route.routePlanner.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface MatrixGeneraionService {

	public JSONObject generateTravelTimeMatrix(String coordinates);

	public JSONObject generateTravelTimeMatrix(String coordinates, String profile);

	public JSONObject generateTravelDistanceMatrix(String coordinates);

	public JSONObject generateTravelDistanceMatrix(String coordinates, String profile);

	public JSONObject generateDistanceAndTimeMatrix(String coordinates);

	public JSONObject generateDistanceAndTimeMatrix(String coordinates, String profile);
}
