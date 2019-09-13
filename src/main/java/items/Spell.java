package items;

public enum Spell {
    FIREBALL(20),
    FROSTBITE(15),
    LIGHTENINGBOLT(25);

    private final int damage;

    Spell(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
