package com.gb.parkinglot.model.parking;

import java.util.HashMap;
import java.util.Map;

public class HourlyCost {
	private Map<ParkingSpotType, Double> hourlyCosts = new HashMap<>();

	public HourlyCost() {
		getHourlyCosts().put(ParkingSpotType.CAR, 20.0);
		getHourlyCosts().put(ParkingSpotType.LARGE, 30.0);
		getHourlyCosts().put(ParkingSpotType.ELECTRIC, 25.0);
		getHourlyCosts().put(ParkingSpotType.MOTORBIKE, 10.0);
		getHourlyCosts().put(ParkingSpotType.ABLED, 25.0);
	}

	public double getCost(ParkingSpotType parkingSpotType) {
		return getHourlyCosts().get(parkingSpotType);
	}

	public Map<ParkingSpotType, Double> getHourlyCosts() {
		return hourlyCosts;
	}

	public void setHourlyCosts(Map<ParkingSpotType, Double> hourlyCosts) {
		this.hourlyCosts = hourlyCosts;
	}
}
