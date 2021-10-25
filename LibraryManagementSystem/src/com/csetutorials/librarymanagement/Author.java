package com.csetutorials.librarymanagement;

import java.util.List;

public class Author extends Person {

	public Author(String firstName, String lastName) {
		super(firstName, lastName);
	}

	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
