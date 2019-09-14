package characters;

import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyTest {

    Enemy enemy;
    Enchanter enchanter;
    Cleric cleric;

    @Before
    public void setUp() {
        cleric = new Cleric(Name.IZZY, Race.ORC, 150, HealingItem.POTION);
        enchanter = new Enchanter(Name.DENICE, Race.DWARF, 200, Familiar.TOAD, Spell.FIREBALL);
        enemy = new Enemy(Name.MELISSA, Race.GNOME, 100, Armour.CUIRASS, Weapon.CLUB);

    }

    @Test
    public void hasName() {
        assertEquals(Name.MELISSA, enemy.getName());
    }

    @Test
    public void hasRace() {
        assertEquals(Race.GNOME, enemy.getRace());
    }

    @Test
    public void hasHealth() {
        assertEquals(100, enemy.getHealth());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.CLUB, enemy.getWeapon());
    }

    @Test
    public void hasWeaponDamage() {
        assertEquals(40, enemy.getWeaponDamage());
    }

    @Test
    public void canDefend() {
        enemy.defend(40);
        assertEquals(90, enemy.getHealth());
    }

    @Test
    public void canAttack() {
        enemy.attack(enchanter);
        assertEquals(20, enchanter.getSpellDamage());
    }

    @Test
    public void canGetHealing() {
        enemy.getHealing(cleric.getItemRestoration());
        assertEquals(115, enemy.getHealth());
    }

    @Test
    public void canGenerateInventory(){
        enemy.generateInventory();
        assertEquals(1, enemy.inventory.getTreasureCount());
    }

    @Test
    public void canGetTotalLoot(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        assertEquals(10, enemy.getTotalLoot());
    }

    @Test
    public void isAliveTrue(){
        assertTrue(enemy.isAlive());
    }

    @Test
    public void isAliveFalse(){
        enemy.defend(1500);
        assertFalse(enemy.isAlive());
    }


}

