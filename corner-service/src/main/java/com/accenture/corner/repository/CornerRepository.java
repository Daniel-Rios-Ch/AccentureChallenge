package com.accenture.corner.repository;

import com.accenture.corner.domain.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CornerRepository extends CrudRepository<Place, String> {

	Place findByName(String name);

}
