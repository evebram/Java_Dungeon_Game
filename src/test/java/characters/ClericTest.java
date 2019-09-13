package characters;

import items.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClericTest {

    Cleric cleric;
    Enchanter enchanter;
    Enemy enemy;

    @Before
    public void setUp() {
        cleric = new Cleric("Toni", "Human", 150, HealingItem.POTION);
        enchanter = new Enchanter("Shonagh", "Dwarf", 200, Familiar.OWL, Spell.FIREBALL);
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);
    }

    @Test
    public void hasName() {
        assertEquals("Toni", cleric.getName());
    }

    @Test
    public void hasType() {
        assertEquals("Human", cleric.getType());
    }

    @Test
    public void hasHealth() {
        assertEquals(150, cleric.getHealth());
    }

    @Test
    public void hasHealingItem() {
        assertEquals(HealingItem.POTION, cleric.getHealingItem());
    }

    @Test
    public void hasItemRestoration() {
        assertEquals(15, cleric.getItemRestoration());
    }

    @Test
    public void canDefend() {
        cleric.defend(enemy.getWeaponDamage());
        assertEquals(110, cleric.getHealth());
    }

    @Test
    public void canHeal() {
        cleric.heal(enchanter);
        assertEquals(215, enchanter.getHealth()); // make sure warrior health goes down
    }

    @Test
    public void canGetTreasure() {
        cleric.getTreasure(Treasure.RUBY);
        assertEquals(1, cleric.getTreasureCount());
    }

    @Test
    public void canCollectReward(){
        enemy.getTreasure(Treasure.RUBY);
        cleric.collectReward(enemy);
        assertEquals(1, cleric.getTreasureCount());
    }

    @Test
    public void canGetHealing() {
        enchanter.getHealing(cleric.getItemRestoration());
        assertEquals(215, enchanter.getHealth());
    }

    @Test
    public void isAliveTrue(){
        assertTrue(cleric.isAlive());
    }

    @Test
    public void isAliveFalse(){
        cleric.defend(500);
        assertFalse(cleric.isAlive());
    }
}
