package com.accenture.corner.service;

import com.accenture.corner.domain.Place;

public interface PlaceService {

	/**
	 * Finds place by given name
	 *
	 * @param placeName
	 * @return found place
	 */
	Place findByName(String placeName);

	/**
	 * Checks if place with the same name already exists
	 * Creates new PLACE with default parameters
	 *
	 * @param name
	 * @return created place
	 */
	Place create(String name);

	/**
	 * Validates and applies incoming place updates
	 *
	 * @param name
	 * @param update
	 */
	void saveChanges(String name, Place update);
}
