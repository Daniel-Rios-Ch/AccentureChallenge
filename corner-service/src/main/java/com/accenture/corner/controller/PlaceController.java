package com.accenture.corner.controller;

import com.accenture.corner.domain.Place;
import com.accenture.corner.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{placeName}", method = RequestMethod.GET)
	public Place getPlaceByName(@PathVariable String placeName) {
		return placeService.findByName(placeName);
	}

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(value = "/{placeName}", method = RequestMethod.PUT)
	public void savePlace(@PathVariable String placeName, @Valid @RequestBody Place place) {
		placeService.saveChanges(placeName, place);
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public Place createNewPlace(@Valid @RequestBody String placeName) {
		return placeService.create(placeName);
	}
}
