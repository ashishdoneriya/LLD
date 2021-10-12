package com.csetutorials.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.csetutorials.models.Theatre;

public class TheatreService {

	/**
	 * key = theatre id
	 */
	private Map<String, Theatre> theatres;

	public TheatreService() {
		this.theatres = new HashMap<>();
	}

	public void addThreatre(Theatre theatre) {
		theatres.put(theatre.getId(), theatre);
	}

	public Collection<Theatre> list() {
		return theatres.values();
	}

	public Theatre get(String theatreId) {
		return theatres.get(theatreId);
	}

}
