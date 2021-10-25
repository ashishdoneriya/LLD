package com.csetutorials.librarymanagement;

import java.util.Date;

public class BookItem {

	private Book book;

	private String id;

	private BookStatus status;

	private Date issuedDate;

	private Date reservedDate;

	private BookLocation location;

	private Member borrower;

	public BookItem(Book book, String id) {
		this.book = book;
		this.id = id;
		this.status = BookStatus.AVAILABLE;
	}

	public boolean isAvailable() {
		return status == BookStatus.AVAILABLE;
	}

	public void setAvailable() {
		this.status = BookStatus.AVAILABLE;
		this.issuedDate = null;
		this.reservedDate = null;
		this.borrower = null;
	}

	public String getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(Date reservedDate) {
		this.reservedDate = reservedDate;
	}

	public BookLocation getLocation() {
		return location;
	}

	public void setLocation(BookLocation location) {
		this.location = location;
	}

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}

}
