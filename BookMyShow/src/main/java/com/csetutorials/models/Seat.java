package com.csetutorials.models;

public class Seat {

	private int rowNumber;

	private int seatNumber;

	public Seat(int rowNumber, int seatNumber) {
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rowNumber;
		result = prime * result + seatNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (rowNumber != other.rowNumber)
			return false;
		if (seatNumber != other.seatNumber)
			return false;
		return true;
	}

}
