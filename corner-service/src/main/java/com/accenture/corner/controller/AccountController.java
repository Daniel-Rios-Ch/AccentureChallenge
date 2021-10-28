package com.accenture.corner.controller;

import com.accenture.corner.domain.Place;
import com.accenture.corner.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class AccountController {

	@Autowired
	private PlaceService placeService;

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Place getPlaceByName(@PathVariable String name) {
		return placeService.findByName(name);
	}

	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Place getCurrentPlace(Principal principal) {
		return placeService.findByName(principal.getName());
	}

	@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentPlace(Principal principal, @Valid @RequestBody Place place) {
		placeService.saveChanges(principal.getName(), place);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Place createNewPlace(@Valid @RequestBody String name) {
		return placeService.create(name);
	}
}
