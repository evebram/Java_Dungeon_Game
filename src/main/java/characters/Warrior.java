package characters;

import behaviours.IAttack;
import behaviours.IDefend;
import items.Armour;
import items.Treasure;
import items.Weapon;

import java.util.ArrayList;

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

    public void defend(int attackPower){ //int damage
        int postArmourDamage = attackPower / armour.getResistance();
        this.takeDamage(postArmourDamage);
    }

    public void attack(IDefend defender) { //calls iDefend of attacked
        int attackPower = this.getWeaponDamage();
        defender.defend(attackPower);
    }



}
