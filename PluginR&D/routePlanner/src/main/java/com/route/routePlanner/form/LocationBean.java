package com.route.routePlanner.form;

import java.util.LinkedList;

public class LocationBean {

	double longitude;
	double latitude;
	LinkedList<Double> distanceMatrixEntry;

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the distanceMatrixEntry
	 */
	public LinkedList<Double> getDistanceMatrixEntry() {
		return distanceMatrixEntry;
	}

	/**
	 * @param distanceMatrixEntry the distanceMatrixEntry to set
	 */
	public void setDistanceMatrixEntry(LinkedList<Double> distanceMatrixEntry) {
		this.distanceMatrixEntry = distanceMatrixEntry;
	}

}
