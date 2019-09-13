package characters;


import behaviours.IAttack;
import behaviours.IDefend;
import items.Treasure;
import items.Weapon;

import java.util.ArrayList;

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

    public void defend(int attackPower){ //int damage
        int postArmourDamage = attackPower;
        this.takeDamage(postArmourDamage);
    }

    public void attack(IDefend target) { //calls iDefend of attacked
        int attackPower = this.getWeaponDamage();
        target.defend(attackPower);
    }

}