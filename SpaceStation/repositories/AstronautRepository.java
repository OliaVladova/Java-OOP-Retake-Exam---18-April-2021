package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.put(model.getName(), model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model.getName()) != null;
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
    }


}
