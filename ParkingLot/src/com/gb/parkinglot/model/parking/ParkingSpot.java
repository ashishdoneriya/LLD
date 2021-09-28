package com.gb.parkinglot.model.parking;

public abstract class ParkingSpot {
	private String parkingSpotId;
	private boolean isFree;
	private ParkingSpotType parkingSpotType;
	private String assignedVehicleId;

	public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType) {
		this.setParkingSpotId(parkingSpotId);
		this.setParkingSpotType(parkingSpotType);
	}

	public void assignVehicleToSpot(String vehicleId) {
		this.setAssignedVehicleId(vehicleId);
	}

	public void freeSpot() {
		this.setFree(true);
		this.setAssignedVehicleId(null);
	}

	public String getParkingSpotId() {
		return parkingSpotId;
	}

	public void setParkingSpotId(String parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}

	public void setParkingSpotType(ParkingSpotType parkingSpotType) {
		this.parkingSpotType = parkingSpotType;
	}

	public String getAssignedVehicleId() {
		return assignedVehicleId;
	}

	public void setAssignedVehicleId(String assignedVehicleId) {
		this.assignedVehicleId = assignedVehicleId;
	}
}
