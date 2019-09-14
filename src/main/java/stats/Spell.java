package stats;

import java.util.Random;

public enum Spell {
    FIREBALL(20),
    FROSTBITE(15),
    LIGHTENINGBOLT(25);

    private final int damage;

    private static final Spell[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Spell getRandomSpell(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    Spell(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
