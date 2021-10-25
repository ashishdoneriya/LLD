package com.csetutorials.librarymanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member extends Person {

	private String id;

	private List<BookItem> reservedBooks;

	private List<BookItem> issuedBooks;

	public Member(String id, String firstName, String lastName) {
		super(firstName, lastName);
		this.id = id;
		this.reservedBooks = new ArrayList<>();
		this.issuedBooks = new ArrayList<>();
	}

	public void reserveBook(Book book) {
		if (!book.isAnyAvailable()) {
			throw new BookNotAvailableException();
		}
		BookItem copy = book.getAnyAvailable();
		copy.setBorrower(this);
		copy.setReservedDate(new Date());
		copy.setStatus(BookStatus.RESERVED);
	}

	public void checkout(BookItem bookItem) {
		bookItem.setIssuedDate(new Date());
		bookItem.setStatus(BookStatus.ISSUED);
	}

	public void issueBook(Book book) {
		if (!book.isAnyAvailable()) {
			throw new BookNotAvailableException();
		}
		BookItem bookItem = book.getAnyAvailable();
		bookItem.setBorrower(this);
		bookItem.setIssuedDate(new Date());
		bookItem.setStatus(BookStatus.ISSUED);
	}

	public Fine submit(BookItem bookItem) {
		Fine fine = FineCalculator.calculateFineIfAny(bookItem);
		bookItem.setAvailable();
		return fine;
	}

	public void payFine(Fine fine, PaymentMethod paymentMethod) {
		paymentMethod.pay(fine.getLateFee());
	}

	public String getId() {
		return id;
	}

	public List<BookItem> getIssuedBooks() {
		return issuedBooks;
	}

	public List<BookItem> getReservedBooks() {
		return reservedBooks;
	}

	public void setId(String id) {
		this.id = id;
	}

}
