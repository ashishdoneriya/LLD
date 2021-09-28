package com.gb.parkinglot.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.gb.parkinglot.exceptions.InvalidParkingLotException;
import com.gb.parkinglot.exceptions.InvlaidParkingFloorException;
import com.gb.parkinglot.model.parking.EntrancePanel;
import com.gb.parkinglot.model.parking.ExitPanel;
import com.gb.parkinglot.model.parking.ParkingFloor;
import com.gb.parkinglot.model.parking.ParkingLot;
import com.gb.parkinglot.model.parking.ParkingSpot;

public class ParkingLotRepository {
	public static Map<String, ParkingLot> parkingLotMap = new HashMap<>();
	public static List<ParkingLot> parkingLots = new ArrayList<>();

	public ParkingLot addParkingLot(ParkingLot parkingLot) {
		parkingLotMap.putIfAbsent(parkingLot.getParkingLotId(), parkingLot);
		parkingLots.add(parkingLot);
		return parkingLot;
	}

	public ParkingLot getParkingLot(String parkingLotId) {
		return parkingLotMap.get(parkingLotId);
	}

	public ParkingFloor addParkingFloor(String parkingLotId, ParkingFloor parkingFloor)
			throws InvalidParkingLotException {
		ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
		if (parkingLot == null)
			throw new InvalidParkingLotException("Invalid parking lot");

		// Idempotency
		Optional<ParkingFloor> floor = parkingLot.getParkingFloors().stream()
				.filter(pFloor -> pFloor.getFloorId().equalsIgnoreCase(parkingFloor.getFloorId())).findFirst();

		if (floor.isPresent())
			return floor.get();

		parkingLot.getParkingFloors().add(parkingFloor);
		return parkingFloor;
	}

	public ParkingSpot addParkingSpot(String parkingLotId, String parkingFloorId, ParkingSpot parkingSpot)
			throws InvalidParkingLotException, InvlaidParkingFloorException {
		ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
		if (parkingLot == null)
			throw new InvalidParkingLotException("Invalid parking lot");
		Optional<ParkingFloor> floor = parkingLot.getParkingFloors().stream()
				.filter(pFloor -> pFloor.getFloorId().equalsIgnoreCase(parkingFloorId)).findFirst();
		if (!floor.isPresent()) {
			throw new InvlaidParkingFloorException("Invalid parking floor");
		}
		Optional<ParkingSpot> spot = floor.get().getFreeParkingSpots().get(parkingSpot.getParkingSpotType()).stream()
				.filter(pSpot -> pSpot.getParkingSpotId().equalsIgnoreCase(parkingSpot.getParkingSpotId())).findFirst();
		if (spot.isPresent())
			return spot.get();

		floor.get().getFreeParkingSpots().get(parkingSpot.getParkingSpotType()).add(parkingSpot);
		return parkingSpot;
	}

	public EntrancePanel addEntryPanel(String parkingLotId, EntrancePanel entrancePanel)
			throws InvalidParkingLotException {
		ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
		if (parkingLot == null)
			throw new InvalidParkingLotException("Invalid parking lot");
		Optional<EntrancePanel> ePanel = parkingLotMap.get(parkingLotId).getEntrancePanels().stream()
				.filter(ep -> ep.getId().equalsIgnoreCase(entrancePanel.getId())).findFirst();
		if (ePanel.isPresent())
			return entrancePanel;
		parkingLotMap.get(parkingLotId).getEntrancePanels().add(entrancePanel);
		return entrancePanel;
	}

	public ExitPanel addExitPanel(String parkingLotId, ExitPanel exitPanel) throws InvalidParkingLotException {
		ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
		if (parkingLot == null)
			throw new InvalidParkingLotException("Invalid parking lot");
		Optional<EntrancePanel> ePanel = parkingLotMap.get(parkingLotId).getEntrancePanels().stream()
				.filter(ep -> ep.getId().equalsIgnoreCase(exitPanel.getId())).findFirst();
		if (ePanel.isPresent())
			return exitPanel;
		parkingLotMap.get(parkingLotId).getExitPanels().add(exitPanel);
		return exitPanel;
	}

}
