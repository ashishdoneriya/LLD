package com.csetutorials.librarymanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

	private String name;

	private Address address;

	/**
	 * key = member id
	 */
	private Map<String, Member> members;

	/**
	 * key = book id
	 */
	private Map<String, Book> books;

	private Search search;

	public Library(String name, Address address) {
		this.name = name;
		this.address = address;
		this.members = new HashMap<>();
		this.books = new HashMap<>();
		this.search = new Search();
	}

	public void addMember(Member member) {
		this.members.put(member.getId(), member);
	}

	public void addBook(Book book) {
		books.put(book.getId(), book);
	}

	public Map<String, Book> getBooks() {
		return books;
	}

	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public Map<String, Member> getMembers() {
		return members;
	}

	public void setMembers(Map<String, Member> members) {
		this.members = members;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Search getSearchObject() {
		return this.search;
	}

	public class Search {
		public Book searchByTitle(String title) {
			for (Book book : books.values()) {
				if (title.equals(book.getTitle())) {
					return book;
				}
			}
			return null;
		}

		public List<Book> searchByAuthor(String authorName) {
			return null;
		}
	}

}
