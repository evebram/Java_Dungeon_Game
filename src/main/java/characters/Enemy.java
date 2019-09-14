package characters;


import behaviours.IDefend;
import stats.*;

public class Enemy extends Entity implements IDefend {

    private Weapon weapon;
    private Armour armour;

    public Enemy(Name name, Race race, int health, Armour armour, Weapon weapon) {
        super(name, race, health);
        this.armour = armour;
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getWeaponDamage() {
        return weapon.getDamage();
    }

    public Armour getArmour() {
        return armour;
    }

    public int getArmourResistance() {
        return armour.getResistance();
    }

    public void defend(int attackPower){
        int postArmourDamage = attackPower / armour.getResistance();
        this.takeDamage(postArmourDamage);
    }

    public void attack(Entity target) {
        if (target.isAlive()) {
            int attackPower = this.getWeaponDamage();
            target.defend(attackPower);
        } else {
            collectReward(target);
        }
    }

    public void generateInventory(){
        inventory.getTreasure(Treasure.getRandomTreasure());
    }

}