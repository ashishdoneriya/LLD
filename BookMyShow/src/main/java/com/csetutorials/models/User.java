package com.csetutorials.models;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String id;

	private String name;

	private List<Booking> bookings;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
		this.bookings = new ArrayList<>(1);
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getId() {
		return id;
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

}
