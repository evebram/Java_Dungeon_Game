package characters;

import behaviours.IDefend;
import inventory.Inventory;
import stats.Health;
import stats.Name;
import stats.Race;
import stats.Treasure;

public abstract class Entity implements IDefend {

    private Name name;
    private Race race;
    private int health;
    Inventory inventory;

    public Entity(Name name, Race race, int health) {
        this.name = name;
        this.race = race;
        this.health = health;
        this.inventory = new Inventory();
    }

    public Name getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public void getHealing(int restoration) {
        health += restoration;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void collectReward(Entity entity){
        if(entity.inventory.getTreasureCount() > 0) {
            Treasure item = entity.inventory.removeItem();
            inventory.getTreasure(item);
        }
    }

    public int getTotalLoot(){
        return this.inventory.getInventoryWorth();
    }

}
