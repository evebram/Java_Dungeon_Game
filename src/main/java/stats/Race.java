package stats;

import java.util.Random;

public enum Race {
    HUMAN,
    UNDEAD,
    DWARF,
    ORC,
    ELF,
    TROLL,
    GNOME,
    HALFLING,
    GOBLIN;

    private static final Race[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Race getRandomRace(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
