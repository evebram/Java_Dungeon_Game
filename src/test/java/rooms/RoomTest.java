package rooms;

import characters.Enemy;
import items.Weapon;
import org.junit.Before;

public class RoomTest {

    Room room;
    Enemy enemy;

    @Before
    public void setUp(){
        this.room = new Room("Room of Doom");
        this.enemy = new Enemy("Chris", "Goblin", 100, Weapon.CLUB);
    }



}
