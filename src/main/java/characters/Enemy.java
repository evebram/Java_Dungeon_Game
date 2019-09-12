package characters;


import behaviours.IAttack;
import behaviours.IDefend;
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

    public void attack(IDefend defender) {
        health -= defender.defend();
    }

    public int defend(IAttack attacker) {
        return attacker.getWeaponDamage();
    }

}