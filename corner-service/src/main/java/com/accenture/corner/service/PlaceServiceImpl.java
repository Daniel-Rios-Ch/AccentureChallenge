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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PlaceServiceImpl implements PlaceService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private List<String> randomTowns = Arrays.asList("San Pedro Garza Garcia", "Monterrey", "Santa Catarina", "Escobedo", "San Nicolas", "Apodaca", "Guadalupe");
	private List<String> randomAddresses = Arrays.asList("Av Roberto Garza Sada 150", "Juan de Lagos 203", "Olmos 234", "Onyx 150", "Botanico 190", "Corderos 20");
	private List<LocationType> locationTypes = Arrays.asList(LocationType.BAR, LocationType.BAKERY, LocationType.COFFEE, LocationType.RESTAURANT);


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
		location.setTown(randomTowns.get(new Random().nextInt(randomTowns.size())));
		location.setAddress(randomAddresses.get(new Random().nextInt(randomAddresses.size())));
		location.setLocationType(locationTypes.get(new Random().nextInt(locationTypes.size())));
		location.setCoordinates("0, 0, 0");
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
