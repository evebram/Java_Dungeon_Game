package characters;

import behaviours.IAttack;
import behaviours.IDefend;
import stats.*;

public class Warrior extends Entity implements IAttack, IDefend {

    private Armour armour;
    private Weapon weapon;

    public Warrior(Name name, Race race, int health, Armour armour, Weapon weapon) {
        super(name, race, health);
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

    public void attack(Entity target) {
        if(target.isAlive()){
            int attackPower = this.getWeaponDamage();
            target.defend(attackPower);
        } else {
            collectReward(target);
        }
    }

}
