package characters;

import behaviours.IDefend;
import behaviours.IHeal;
import stats.HealingItem;
import stats.Name;
import stats.Race;

public class Cleric extends Entity implements IDefend, IHeal {

    private HealingItem healingItem;

    public Cleric(Name name, Race race, int health, HealingItem healingItem) {
        super(name, race, health);
        this.healingItem = healingItem;
    }

    public HealingItem getHealingItem() {
        return healingItem;
    }

    public int getItemRestoration() {
        return healingItem.getRestoration();
    }

    public void defend(int attackPower){ //int damage
        int postArmourDamage = attackPower;
        this.takeDamage(postArmourDamage);
    }

    public void heal(Entity target) {
        int restoration = this.getItemRestoration();
        target.getHealing(restoration);
    }

}
