package com.csetutorials.v1;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	private List<ParkingFloor> parkingFloors;

	public ParkingLot() {
		this.parkingFloors = new ArrayList<>();
	}

	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}

	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public boolean isParkingAvailable(VehicleType type) {
		for (ParkingFloor floor : this.parkingFloors) {
			if (floor.isAvailable(type)) {
				return true;
			}
		}
		return false;
	}
	
	public ParkingSlot park(Vehicle vehicle) {
		for (ParkingFloor floor : this.parkingFloors) {
			if (floor.isAvailable(vehicle.getVehicleType())) {
				return floor.park(vehicle);
			}
		}
		return null;
	}

}
