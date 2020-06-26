package com.route.routePlanner.mtrixAPI;

import org.json.JSONObject;

public class TestTableService {
	Table t = new Table();

	/**
	 * Make request with only locations
	 */
	public void testDefaultTableRequest() {
		JSONObject tableDefault = t.generateTravelTimeMatrix("18.6151,73.765693;18.5809,73.6879");
		System.out.println(tableDefault);
	}

	/**
	 * Make request with locations and mode of travel
	 */
	public void testTableRequestWithProfile() {
		JSONObject tableWithProfile = t.generateTravelTimeMatrix("18.6151,73.765693;18.5809,73.6879", "car");
		System.out.println(tableWithProfile);
	}

	public static void main(String[] args) {
		TestTableService test = new TestTableService();
		test.testDefaultTableRequest();
	}
}
