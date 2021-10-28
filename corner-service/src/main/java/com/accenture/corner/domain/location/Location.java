package com.accenture.corner.domain.location;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Location {

    @NotNull private String country;
    @NotNull private String state;
    @NotNull private String town;
    @NotNull private String address;
    @Valid @NotNull private LocationType locationType;
    @NotNull private String coordinates;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }
}
