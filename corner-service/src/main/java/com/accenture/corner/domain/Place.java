package com.accenture.corner.domain;

import com.accenture.corner.domain.location.Location;
import com.accenture.corner.domain.menu.Menu;
import com.accenture.corner.domain.review.Review;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Document(collection = "place")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

	@Id
	private String name;

	@Valid @NotNull private List<Review> reviews;
	@Valid @NotNull private List<Menu> menus;

	@Valid @NotNull private Location location;
	@NotNull private double score;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}
}
