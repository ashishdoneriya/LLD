package com.csetutorials.models;

import java.util.ArrayList;
import java.util.List;

public class Audi {

	private String id;

	private String name;

	private List<Seat> seats;

	public String getId() {
		return id;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addSeat(Seat seat) {
		if (this.seats == null) {
			this.seats = new ArrayList<>();
		}
		this.seats.add(seat);
	}

	public void addSeats(List<Seat> seats) {
		if (this.seats == null) {
			this.seats = new ArrayList<>();
		}
		this.seats.addAll(seats);
	}

}
