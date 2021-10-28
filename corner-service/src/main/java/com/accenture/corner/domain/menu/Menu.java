package com.accenture.corner.domain.menu;

import com.accenture.corner.domain.menu.item.Item;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Menu {

    @NotNull private String name;
    @Valid @NotNull private List<Item> items;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
