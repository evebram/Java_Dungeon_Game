package stats;

import java.util.Random;

public enum Familiar {

    TOAD(2),
    OWL(3),
    WYVERN(4);

    private final int resistance;

    private static final Familiar[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Familiar getRandomFamiliar(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    Familiar(int resistance) {
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }
}
