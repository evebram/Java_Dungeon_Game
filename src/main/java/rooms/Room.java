package rooms;

import characters.Enemy;

import static items.Treasure.getRandomTreasure;

public class Room {

    private Room room;
    private String name;

    public Room(String name){
        this.name = name;
    }

    public void generateEnemy(Enemy enemy){
        enemy.getTreasure(getRandomTreasure());
    }


}
