package spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;

import java.util.*;

public class PlanetImpl implements Planet {
    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
       this.setName(name);
        this.items = new ArrayList<>();
    }

    private void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }else {
            this.name = name;
        }
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
