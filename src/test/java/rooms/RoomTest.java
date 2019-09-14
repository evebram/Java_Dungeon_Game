package rooms;

import characters.Enemy;
import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;

    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;

    @Before
    public void setUp(){
        this.room = new Room(Dungeon.DUNGEON1);
        this.enemy1 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 80, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy2 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 120, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy3 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 160, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy4 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 200, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy5 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 240, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy6 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 280, Armour.getRandomArmour(), Weapon.getRandomWeapon());

        room.addEnemyToAdversaries(enemy1);
        room.addEnemyToAdversaries(enemy2);
        room.addEnemyToAdversaries(enemy3);
        room.addEnemyToAdversaries(enemy4);
        room.addEnemyToAdversaries(enemy5);
        room.addEnemyToAdversaries(enemy6);

    }

    @Test
    public void canGetCombatants(){
        assertEquals(0, room.getCombatantsTotal());
    }

    @Test
    public void canGetAdversaries(){
        assertEquals(6, room.getAdversariesTotal());
    }

//    @Test
//    public void canGenerateEnemy(){
//        room.generateEnemy();
//        assertEquals(1, room.getCombatantsTotal());
//    }

//    @Test
//    public void canRoomPopulate(){
//        room.getNewRoom();
//        assertEquals(2, room.getEnemyTotal());
//    }



}
