package characters;

import behaviours.IAttack;
import behaviours.IDefend;
import items.Armour;
import items.Weapon;

public class Warrior extends Entity implements IAttack, IDefend {

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

    public int defend(IAttack attacker){ //int damage
       return attacker.getWeaponDamage() // getArmourResistance();
    }

    public void attack(IDefend defender) { //calls iDefend of attacked
        health -= defender.defend(attackStrength);
    }



}
