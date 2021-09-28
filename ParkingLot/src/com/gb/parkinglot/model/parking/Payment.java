package com.gb.parkinglot.model.parking;

import java.time.LocalDateTime;

public class Payment {
	private String id;
	private String ticketId;
	private double amount;

	private LocalDateTime initiatedDate;
	private LocalDateTime completedDate;
	private PaymentStatus paymentStatus;

	public Payment(String id, String ticketId, double amount) {
		this.id = id;
		this.ticketId = ticketId;
		this.amount = amount;
	}

	public void makePayment() {
		this.initiatedDate = LocalDateTime.now();
		this.paymentStatus = PaymentStatus.SUCCESS;
		this.completedDate = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(LocalDateTime initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public LocalDateTime getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDateTime completedDate) {
		this.completedDate = completedDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
