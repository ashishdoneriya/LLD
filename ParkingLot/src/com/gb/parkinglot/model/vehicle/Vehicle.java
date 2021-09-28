package com.gb.parkinglot.model.vehicle;

import com.gb.parkinglot.model.parking.ParkingTicket;

public abstract class Vehicle {
	private String licenseNumber;
	private final VehicleType type;
	private ParkingTicket ticket;

	public Vehicle(String licenseNumber, VehicleType type) {
		this.licenseNumber = licenseNumber;
		this.type = type;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public ParkingTicket getTicket() {
		return ticket;
	}

	public void setTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}

	public VehicleType getType() {
		return type;
	}
}
