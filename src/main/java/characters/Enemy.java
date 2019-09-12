package characters;


import items.Weapon;

public class Enemy extends Entity {

    private Weapon weapon;

    public Enemy(String name, String type, int health, Weapon weapon) {
        super(name, type, health);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getWeaponDamage() {
        return weapon.getDamage();
    }


}