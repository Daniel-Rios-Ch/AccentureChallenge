package com.accenture.corner.domain.menu.item;

import javax.validation.constraints.NotNull;

public class Item {

    @NotNull private String name;
    @NotNull private double cost;
    @NotNull private double discount;
    @NotNull private boolean available;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
