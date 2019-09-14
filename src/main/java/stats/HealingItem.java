package stats;

import java.util.Random;

public enum HealingItem {

    HERBS(10),
    POTION(15),
    HEALINGPRAYER(20);

    private final int restore;

    private static final HealingItem[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static HealingItem getRandomItem(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    HealingItem(int restore) {
        this.restore = restore;
    }

    public int getRestoration() {
        return restore;
    }
}
