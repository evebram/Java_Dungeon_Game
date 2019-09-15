package rooms;

import characters.Enemy;
import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room1;
    Room room2;

    Enemy enemyDead;
    Enemy enemyAlive;


    @Before
    public void setUp(){
        this.room1 = new Room(Dungeon.DUNGEON1);
        this.room2 = new Room(Dungeon.DUNGEON3);

        this.enemyDead = new Enemy(Name.getRandomName(), Race.getRandomRace(), 0, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemyAlive = new Enemy(Name.getRandomName(), Race.getRandomRace(), 80, Armour.getRandomArmour(), Weapon.getRandomWeapon());

    }

    @Test
    public void canGetCombatants(){
        assertEquals(0, room1.getCombatantsTotal());
    }

    @Test
    public void canGetAdversaries(){
        assertEquals(3, room1.getAdversariesTotal());
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

    @Test
    public void canCheckIfCompleteFalse(){
        room1.addEnemyToCombatants(enemyAlive);
        assertEquals(false, room1.isComplete());
    }

    @Test
    public void canCheckIfCompleteTrue(){
        room1.addEnemyToCombatants(enemyDead);
        assertEquals(true, room1.isComplete());
    }

    @Test
    public void canGetInventory(){
        room1.generateEnemy();
        assertEquals(1, room1.returnCombatantsInventory());
    }

}
