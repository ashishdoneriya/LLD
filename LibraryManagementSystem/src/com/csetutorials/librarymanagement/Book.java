package com.csetutorials.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Book {

	/**
	 * book id
	 */
	private String id;
	private String title;
	private List<Author> authors;
	private String subject;
	private List<BookItem> copies;

	public Book(String id, String title, List<Author> authors, String subject) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.subject = subject;
		this.copies = new ArrayList<>();
	}

	public void addCopy(BookItem bookItem) {
		this.copies.add(bookItem);
	}

	public boolean isAnyAvailable() {
		for (BookItem copy : this.copies) {
			if (copy.isAvailable()) {
				return true;
			}
		}
		return false;
	}

	public BookItem getAnyAvailable() {
		for (BookItem copy : this.copies) {
			if (copy.isAvailable()) {
				return copy;
			}
		}
		throw new BookNotAvailableException();
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BookItem> getCopies() {
		return copies;
	}

	public void setCopies(List<BookItem> copies) {
		this.copies = copies;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
