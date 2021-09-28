package com.csetutorials.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {

	private int floorNumber;

	private Map<VehicleType, List<ParkingSlot>> busySlotsMap, availableSlotsMap;

	public ParkingFloor(int floorNumber) {
		this.floorNumber = floorNumber;
		this.busySlotsMap = new ConcurrentHashMap<>();
		this.availableSlotsMap = new ConcurrentHashMap<>();
	}

	public boolean isAvailable(VehicleType type) {
		List<ParkingSlot> slots = this.availableSlotsMap.get(type);
		return (slots == null || slots.isEmpty());
	}

	public ParkingSlot park(Vehicle vehicle) {
		List<ParkingSlot> slots = this.availableSlotsMap.get(vehicle.getVehicleType());
		ParkingSlot slot = slots.remove(slots.size() - 1);
		slot.setParkedVehicle(vehicle);
		List<ParkingSlot> busySlots = this.busySlotsMap.get(vehicle.getVehicleType());
		if (busySlots == null) {
			busySlots = new ArrayList<>();
			this.busySlotsMap.put(vehicle.getVehicleType(), busySlots);
		}
		busySlots.add(slot);
		return slot;
	}

	// Only for parking managers
	public synchronized void addSlots(VehicleType vehicleType, int slots) {
		int lastSlot = getLastSlotNumber(vehicleType);
		while (slots-- > 0) {
			ParkingSlot slot = new ParkingSlot(vehicleType, ++lastSlot, floorNumber);
			List<ParkingSlot> list = this.availableSlotsMap.get(vehicleType);
			if (list == null) {
				list = new ArrayList<>();
				this.availableSlotsMap.put(vehicleType, list);
			}
			list.add(slot);
		}
	}

	private int getLastSlotNumber(VehicleType vehicleType) {
		int maxNumber = 0;
		if (this.busySlotsMap.containsKey(vehicleType)) {
			for (ParkingSlot slot : this.busySlotsMap.get(vehicleType)) {
				if (maxNumber < slot.getSlotNumber()) {
					maxNumber = slot.getSlotNumber();
				}
			}
		}
		if (this.availableSlotsMap.containsKey(vehicleType)) {
			for (ParkingSlot slot : this.availableSlotsMap.get(vehicleType)) {
				if (maxNumber < slot.getSlotNumber()) {
					maxNumber = slot.getSlotNumber();
				}
			}
		}
		return maxNumber;
	}

}
