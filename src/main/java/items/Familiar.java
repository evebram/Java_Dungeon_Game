package items;

public enum Familiar {

    TOAD(2),
    OWL(3),
    WYVERN(4);

    private final int resistance;

    Familiar(int resistance) {
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }
}
