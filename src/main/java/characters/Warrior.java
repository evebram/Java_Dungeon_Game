package characters;

import items.Armour;
import items.Weapon;

public class Warrior extends Entity {

    private Armour armour;
    private Weapon weapon;

    public Warrior(String name, String type, int health, Armour armour, Weapon weapon) {
        super(name, type, health);
        this.armour = armour;
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public int getArmourResistance() {
        return armour.getResistance();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getWeaponDamage() {
        return weapon.getDamage();
    }


}
