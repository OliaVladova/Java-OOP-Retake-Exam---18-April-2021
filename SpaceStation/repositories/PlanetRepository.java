package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet model) {
        this.planets.put(model.getName(), model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model.getName()) != null;
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}
