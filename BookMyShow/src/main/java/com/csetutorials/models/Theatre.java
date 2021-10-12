package com.csetutorials.models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	private String id;

	private String name;

	private Address address;

	private List<Audi> audis;

	private List<Show> shows;

	public Theatre(String id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.audis = new ArrayList<>();
		this.shows = new ArrayList<>();
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Audi> getAudis() {
		return audis;
	}

	public void setAudis(List<Audi> audis) {
		this.audis = audis;
	}

	public void addAudi(Audi audi) {
		this.audis.add(audi);
	}

	public void addShow(Show show) {
		this.shows.add(show);
	}

}
