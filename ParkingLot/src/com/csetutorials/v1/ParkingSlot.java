package com.csetutorials.v1;

public class ParkingSlot {

	private int floorNumber;

	private int slotNumber;

	private VehicleType vehicleType;

	private Vehicle parkedVehicle;

	public ParkingSlot(VehicleType type, int slotNumber, int floorNumber) {
		this.vehicleType = type;
		this.slotNumber = slotNumber;
		this.floorNumber = floorNumber;
	}

	public boolean isSlotAvailable() {
		return this.parkedVehicle == null;
	}

	public void setFree() {
		this.parkedVehicle = null;
	}

	public void park(Vehicle vehicle) {
		this.parkedVehicle = vehicle;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}

	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

}
