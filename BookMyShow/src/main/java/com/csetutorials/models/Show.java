package com.csetutorials.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {

	private Movie movie;

	private Audi audi;

	private Date showTime;

	private int duration;

	private List<Booking> bookings;

	public Show(Movie movie, Audi audi, Date showTime, int duration) {
		this.movie = movie;
		this.audi = audi;
		this.showTime = showTime;
		this.duration = duration;
		this.bookings = new ArrayList<>();
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Audi getAudi() {
		return audi;
	}

	public void setAudi(Audi audi) {
		this.audi = audi;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}

	public List<Seat> getAvailableSeats() {
		List<Seat> seats = new ArrayList<>(this.audi.getSeats());
		for (Booking booking : this.bookings) {
			seats.removeAll(booking.getSeats());
		}
		return seats;
	}

}
