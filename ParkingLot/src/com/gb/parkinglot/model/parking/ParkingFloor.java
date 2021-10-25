package com.gb.parkinglot.model.parking;

import static com.gb.parkinglot.model.parking.ParkingSpotType.CAR;
import static com.gb.parkinglot.model.parking.ParkingSpotType.ELECTRIC;
import static com.gb.parkinglot.model.parking.ParkingSpotType.LARGE;
import static com.gb.parkinglot.model.parking.ParkingSpotType.MOTORBIKE;

import java.util.BitSet;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import com.gb.parkinglot.model.vehicle.VehicleType;

public class ParkingFloor {

	private String floorId;

	private Map<ParkingSpotType, Deque<ParkingSpot>> freeParkingSpots = new HashMap<>();
	private Map<String, ParkingSpot> usedParkingSpots = new HashMap<>();

	public ParkingFloor(String id) {
		this.setFloorId(id);
		for (ParkingSpotType type : ParkingSpotType.values()) {
			getFreeParkingSpots().put(type, new ConcurrentLinkedDeque<ParkingSpot>());
		}
	}

	public boolean isFloorFull() {
		BitSet fullBitSet = new BitSet();
		int bitIndex = 0;
		for (Map.Entry<ParkingSpotType, Deque<ParkingSpot>> entry : getFreeParkingSpots().entrySet()) {
			if (entry.getValue().size() == 0) {
				fullBitSet.set(bitIndex++);
			} else {
				break;
			}
		}
		return fullBitSet.cardinality() == fullBitSet.size();
	}

	public static ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
		switch (vehicleType) {
		case CAR:
			return CAR;
		case ELECTRIC:
			return ELECTRIC;
		case MOTORBIKE:
			return MOTORBIKE;
		default:
			return LARGE;
		}
	}

	public boolean canPark(VehicleType vehicleType) {
		return canPark(getSpotTypeForVehicle(vehicleType));
	}

	public synchronized ParkingSpot getSpot(VehicleType vehicleType) {
		if (!canPark(getSpotTypeForVehicle(vehicleType)))
			return null;

		ParkingSpotType parkingSpotType = getSpotTypeForVehicle(vehicleType);
		ParkingSpot parkingSpot = getFreeParkingSpots().get(parkingSpotType).poll();

		getUsedParkingSpots().put(parkingSpot.getParkingSpotId(), parkingSpot);
		return parkingSpot;
	}

	public ParkingSpot vacateSpot(String parkingSpotId) {
		ParkingSpot parkingSpot = getUsedParkingSpots().remove(parkingSpotId);
		if (parkingSpot != null) {
			parkingSpot.freeSpot();
			getFreeParkingSpots().get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
			return parkingSpot;
		}
		return null;
	}

	public boolean canPark(ParkingSpotType parkingSpotType) {
		return getFreeParkingSpots().get(parkingSpotType).size() > 0;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public Map<ParkingSpotType, Deque<ParkingSpot>> getFreeParkingSpots() {
		return freeParkingSpots;
	}

	public Map<String, ParkingSpot> getUsedParkingSpots() {
		return usedParkingSpots;
	}

}
