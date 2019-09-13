package items;

public enum Weapon {

    SWORD(20),
    AXE(25),
    CLUB(40);

    private final int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
