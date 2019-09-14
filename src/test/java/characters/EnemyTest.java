package characters;

import items.Armour;
import items.HealingItem;
import items.Treasure;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyTest {

    Enemy enemy;
    Warrior warrior;
    Cleric cleric;

    @Before
    public void setUp() {
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);
        warrior = new Warrior("Eve", "Dwarf", 400, Armour.HELMET, Weapon.CLUB);
        cleric = new Cleric("Toni", "Human", 150, HealingItem.POTION);

    }

    @Test
    public void hasName() {
        assertEquals("Ben", enemy.getName());
    }

    @Test
    public void hasType() {
        assertEquals("Troll", enemy.getType());
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
        assertEquals(60, enemy.getHealth()); // make sure enemy attack goes down
    }

    @Test
    public void canAttack() {
        enemy.attack(warrior);
        assertEquals(40, warrior.getWeaponDamage()); // make sure warrior health goes down
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

