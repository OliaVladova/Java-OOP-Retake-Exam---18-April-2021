package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        } else {
            this.name = name;
        }
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        } else {
            this.oxygen = oxygen;
        }
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public boolean canBreath() {
        if (this.oxygen > 0) {
            return true;
        }
        return false;
    }

    private void setBag(Backpack bag) {
        this.bag = bag;
    }

    public void breath() {
        if (this.oxygen >= 10) {
            this.oxygen -= 10;
        }else {
            this.oxygen = 0;
        }
    }
    @Override
    public String toString() {
        String bagItems = this.getBag().getItems().size() == 0
                ? ConstantMessages.EMPTY_BAG
                : String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.bag.getItems());

        StringBuilder builder = new StringBuilder();

        builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, this.name)).append(System.lineSeparator());
        builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, this.oxygen)).append(System.lineSeparator());
        builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, bagItems));

        return builder.toString().trim();
    }
}
