package com.gb.parkinglot.model.parking;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.UUID;

import com.gb.parkinglot.model.account.common.Address;
import com.gb.parkinglot.model.vehicle.VehicleType;

public class ParkingLot {
	private String parkingLotId;
	private Address address;

	private List<ParkingFloor> parkingFloors;
	private List<EntrancePanel> entrancePanels;
	private List<ExitPanel> exitPanels;

	public static ParkingLot INSTANCE = new ParkingLot();

	private ParkingLot() {
		this.parkingLotId = UUID.randomUUID().toString();
		parkingFloors = new ArrayList<>();
		entrancePanels = new ArrayList<>();
		exitPanels = new ArrayList<>();
	}

	public boolean isFull() {
		int index = 0;
		BitSet bitSet = new BitSet();
		for (ParkingFloor parkingFloor : parkingFloors) {
			bitSet.set(index++, parkingFloor.isFloorFull());
		}
		return bitSet.cardinality() == bitSet.size();
	}

	public boolean canPark(VehicleType vehicleType) {
		for (ParkingFloor parkingFloor : parkingFloors) {
			if (parkingFloor.canPark(ParkingFloor.getSpotTypeForVehicle(vehicleType)))
				return true;
		}
		return false;
	}

	public ParkingSpot getParkingSpot(VehicleType vehicleType) {
		for (ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
			ParkingSpot parkingSpot = parkingFloor.getSpot(vehicleType);
			if (parkingSpot != null) {
				return parkingSpot;
			}
		}
		return null;
	}

	public ParkingSpot vacateParkingSpot(String parkingSpotId) {
		for (ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
			ParkingSpot parkingSpot = parkingFloor.vacateSpot(parkingSpotId);
			if (parkingSpot != null)
				return parkingSpot;
		}
		return null;
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}

	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public List<EntrancePanel> getEntrancePanels() {
		return entrancePanels;
	}

	public void setEntrancePanels(List<EntrancePanel> entrancePanels) {
		this.entrancePanels = entrancePanels;
	}

	public List<ExitPanel> getExitPanels() {
		return exitPanels;
	}

	public void setExitPanels(List<ExitPanel> exitPanels) {
		this.exitPanels = exitPanels;
	}

	public static ParkingLot getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(ParkingLot iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
}
