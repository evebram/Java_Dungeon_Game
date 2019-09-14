package rooms;

import characters.Enemy;
import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room1;
    Room room2;

    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;

    @Before
    public void setUp(){
        this.room1 = new Room(Dungeon.DUNGEON1);
        this.room2 = new Room(Dungeon.DUNGEON3);
        this.enemy1 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 80, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy2 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 120, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy3 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 160, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy4 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 200, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy5 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 240, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy6 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 280, Armour.getRandomArmour(), Weapon.getRandomWeapon());

        room1.addEnemyToAdversaries(enemy1);
        room1.addEnemyToAdversaries(enemy2);
        room1.addEnemyToAdversaries(enemy3);
        room1.addEnemyToAdversaries(enemy4);
        room1.addEnemyToAdversaries(enemy5);
        room1.addEnemyToAdversaries(enemy6);

        room2.addEnemyToAdversaries(enemy1);
        room2.addEnemyToAdversaries(enemy2);
        room2.addEnemyToAdversaries(enemy3);
        room2.addEnemyToAdversaries(enemy4);
        room2.addEnemyToAdversaries(enemy5);
        room2.addEnemyToAdversaries(enemy6);

    }

    @Test
    public void canGetCombatants(){
        assertEquals(0, room1.getCombatantsTotal());
    }

    @Test
    public void canGetAdversaries(){
        assertEquals(6, room1.getAdversariesTotal());
    }

    @Test
    public void canGenerateEnemyRoom1(){
        room1.generateEnemy();
        assertEquals(1, room1.getCombatantsTotal());
    }

    @Test
    public void canGenerateEnemyRoom2(){
        room2.generateEnemy();
        assertEquals(3, room2.getCombatantsTotal());
    }

//    @Test
//    public void canGetInventory(){
//        room1.generateEnemy();
//        assertEquals(1, room1.returnCombatantsInventory());
//    }

}
