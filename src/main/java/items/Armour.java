package items;

public enum Armour {

    HELMET(3),
    CUIRASS(4),
    GAUNTLETS(2);

    private final int resistance;

    Armour(int resistance) {
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }
}
