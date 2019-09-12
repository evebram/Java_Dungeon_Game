package characters;

import behaviours.IAttack;
import behaviours.IDefend;
import items.Treasure;

import java.util.ArrayList;

public abstract class Entity implements IDefend {

    private String name;
    private String type;
    private int health;
    private ArrayList<Treasure> inventory;

    public Entity(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.inventory = new ArrayList<Treasure>();
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

    public void getTreasure(Treasure item){
        inventory.add(item);
    }

    public void collectReward(Entity entity){
        if(entity.getTreasureCount() > 0) {
            Treasure treasure = entity.inventory.remove(0);
            inventory.add(treasure);
        }
    }

    public int getTreasureCount(){
        return inventory.size();
    }

}
