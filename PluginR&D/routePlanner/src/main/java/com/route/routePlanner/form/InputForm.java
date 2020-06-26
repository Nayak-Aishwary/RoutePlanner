package com.route.routePlanner.form;

public class InputForm {

	long[][] distanceMatrix;
	int vehicleNumber;
	int depotIndex;

	/**
	 * @return the distanceMatrix
	 */
	public long[][] getDistanceMatrix() {
		return distanceMatrix;
	}

	/**
	 * @param distanceMatrix the distanceMatrix to set
	 */
	public void setDistanceMatrix(long[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}

	/**
	 * @return the vehicleNumber
	 */
	public int getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the depotIndex
	 */
	public int getDepotIndex() {
		return depotIndex;
	}

	/**
	 * @param depotIndex the depotIndex to set
	 */
	public void setDepotIndex(int depotIndex) {
		this.depotIndex = depotIndex;
	}
}
