package stats;

import java.util.Random;

public enum Health {
    WEAK(80),
    AVERAGE(120),
    STRONG(160),
    LEGENDARY(200);

    private final int hitpoints;

    private static final Health[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Health getRandomHealth(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    Health(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getHitpoints() {
        return hitpoints;
    }
}
