package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final int OXYGEN = 70;
    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath(){
        if (this.getOxygen()>=5){
            super.setOxygen(this.getOxygen()-5);
        }else {
            super.setOxygen(0);
        }
    }
}
