package characters;

import behaviours.IAttack;
import behaviours.IDefend;

public abstract class Entity implements IDefend {

    private String name;
    private String type;
    public int health;
//    private ArrayList<treasure> inventory;

    public Entity(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
//        this.inventory = new ArrayList<treasure>();
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

    public void takeDamage(){
        health -= defend(IAttack attacker);
    }

    public int defend(IAttack attacker) {
        return attackStrength = attacker.getWeaponDamage();
    }


}
