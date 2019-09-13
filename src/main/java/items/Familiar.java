package items;

public enum Familiar {

    TOAD(2),
    OWL(3),
    WYVERN(4);

    private final int resistance;

    Familiar(int resisitance) {
        this.resistance = resisitance;
    }

    public int getResistance() {
        return resistance;
    }
}
