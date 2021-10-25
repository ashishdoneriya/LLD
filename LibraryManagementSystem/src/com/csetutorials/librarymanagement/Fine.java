package com.csetutorials.librarymanagement;

public class Fine {

	private double lateFee;

	private int days;

	public Fine(double lateFee, int days) {
		this.lateFee = lateFee;
		this.days = days;
	}

	public double getLateFee() {
		return lateFee;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

}
