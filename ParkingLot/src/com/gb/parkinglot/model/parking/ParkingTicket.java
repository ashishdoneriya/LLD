package com.gb.parkinglot.model.parking;

import java.time.LocalDateTime;

public class ParkingTicket {
	private String ticketNumber;
	private String licensePlateNumber;
	private String allocatedSpotId;
	private LocalDateTime issuedAt;
	private LocalDateTime vacatedAt;
	private double charges;
	private TicketStatus ticketStatus;

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getAllocatedSpotId() {
		return allocatedSpotId;
	}

	public void setAllocatedSpotId(String allocatedSpotId) {
		this.allocatedSpotId = allocatedSpotId;
	}

	public LocalDateTime getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(LocalDateTime issuedAt) {
		this.issuedAt = issuedAt;
	}

	public LocalDateTime getVacatedAt() {
		return vacatedAt;
	}

	public void setVacatedAt(LocalDateTime vacatedAt) {
		this.vacatedAt = vacatedAt;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
}
