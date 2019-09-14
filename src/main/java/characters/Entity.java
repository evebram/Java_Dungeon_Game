package characters;

import behaviours.IDefend;
import inventory.Inventory;
import items.Treasure;

public abstract class Entity implements IDefend {

    private String name;
    private String type;
    private int health;
    Inventory inventory;

    public Entity(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

    public void collectReward(Entity entity, Treasure item){
        if(entity.inventory.getTreasureCount() > 0) {
            entity.inventory.removeItem();
            inventory.getTreasure(item);
        }
    }

    public int getTotalLoot(){
        return this.inventory.getInventoryWorth();
    }

}
