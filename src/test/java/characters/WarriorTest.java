package characters;

import items.Armour;
import items.HealingItem;
import items.Treasure;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {

    Warrior warrior;
    Enemy enemy;
    Cleric cleric;

    @Before
    public void setUp() {
        warrior = new Warrior("Eve", "Dwarf", 400, Armour.HELMET, Weapon.CLUB);
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);
        cleric = new Cleric("Toni", "Monk", 150, HealingItem.POTION);
    }

    @Test
    public void hasName() {
        assertEquals("Eve", warrior.getName());
    }

    @Test
    public void hasType() {
        assertEquals("Dwarf", warrior.getType());
    }

    @Test
    public void hasHealth() {
        assertEquals(400, warrior.getHealth());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.HELMET, warrior.getArmour());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.CLUB, warrior.getWeapon());
    }

    @Test
    public void hasArmourResistance() {
        assertEquals(3, warrior.getArmourResistance());
    }

    @Test
    public void hasWeaponDamage() {
        assertEquals(40, warrior.getWeaponDamage());
    }

    @Test
    public void canDefend() {
        warrior.defend(40);
        assertEquals(387, warrior.getHealth()); // make sure enemy attack goes down
    }

    @Test
    public void canAttack() {
        warrior.attack(enemy);
        assertEquals(40, enemy.getWeaponDamage()); // make sure warrior health goes down
    }

    @Test
    public void canCollectReward(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        warrior.collectReward(enemy, Treasure.RUBY);
        assertEquals(1, warrior.inventory.getTreasureCount());
    }

    @Test
    public void canGetHealing() {
        warrior.getHealing(cleric.getItemRestoration());
        assertEquals(415, warrior.getHealth());
    }

    @Test
    public void isAliveTrue(){
        assertTrue(warrior.isAlive());
    }

    @Test
    public void isAliveFalse(){
        warrior.defend(1500);
        assertFalse(warrior.isAlive());
    }

}
