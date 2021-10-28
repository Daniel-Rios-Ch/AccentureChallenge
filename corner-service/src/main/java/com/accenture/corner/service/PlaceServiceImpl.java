package com.accenture.corner.service;


import com.accenture.corner.domain.Place;
import com.accenture.corner.domain.location.Location;
import com.accenture.corner.domain.location.LocationType;
import com.accenture.corner.repository.CornerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;

@Service
public class PlaceServiceImpl implements PlaceService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private CornerRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Place findByName(String placeName) {
		Assert.hasLength(placeName);
		return repository.findByName(placeName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Place create(String name) {

		Place existing = repository.findByName(name);
		Assert.isNull(existing, "place already exists: " + name);

		Place place = new Place();
		place.setName(name);

		Location location = new Location();
		location.setCountry("Mexico");
		location.setState("Nuevo Leon");
		location.setTown("San Pedro Garza Garcia");
		location.setAddress("Av. Gomez Morin 181");
		location.setCoordinates("0, 0, 0");
		location.setLocationType(LocationType.DEFAULT);
		place.setLocation(location);

		place.setReviews(new ArrayList<>());
		place.setMenus(new ArrayList<>());
		place.setScore(0.0);

		repository.save(place);

		log.info("new place has been created: " + place.getName());

		return place;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveChanges(String name, Place update) {

		Place place = repository.findByName(name);
		Assert.notNull(place, "can't find place with name " + name);

		place.setName(place.getName());
		place.setReviews(update.getReviews());
		place.setMenus(update.getMenus());
		place.setLocation(update.getLocation());
		place.setScore(update.getScore());
		repository.save(place);

		log.debug("place {} changes has been saved", name);
	}
}
