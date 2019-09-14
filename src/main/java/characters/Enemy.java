package characters;


import behaviours.IDefend;
import stats.Name;
import stats.Race;
import stats.Treasure;
import stats.Weapon;

public class Enemy extends Entity implements IDefend {

    private Weapon weapon;

    public Enemy(Name name, Race race, int health, Weapon weapon) {
        super(name, race, health);
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