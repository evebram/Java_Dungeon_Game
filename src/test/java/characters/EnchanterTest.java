package characters;

import items.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnchanterTest {

    Enchanter enchanter;
    Enemy enemy;
    Cleric cleric;

    @Before
    public void setUp() {
        enchanter = new Enchanter("Shonagh", "Dwarf", 200, Familiar.OWL, Spell.FIREBALL);
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);
        cleric = new Cleric("Toni", "Human", 150, HealingItem.POTION);
    }

    @Test
    public void hasName() {
        assertEquals("Shonagh", enchanter.getName());
    }

    @Test
    public void hasType() {
        assertEquals("Dwarf", enchanter.getType());
    }

    @Test
    public void hasHealth() {
        assertEquals(200, enchanter.getHealth());
    }

    @Test
    public void hasFamiliar() {
        assertEquals(Familiar.OWL, enchanter.getFamiliar());
    }

    @Test
    public void hasSpell() {
        assertEquals(Spell.FIREBALL, enchanter.getSpell());
    }

    @Test
    public void hasFamiliarResistance() {
        assertEquals(3, enchanter.getFamiliarResistance());
    }

    @Test
    public void hasSpellDamage() {
        assertEquals(20, enchanter.getSpellDamage());
    }

    @Test
    public void canDefend() {
        enchanter.defend(enemy.getWeaponDamage());
        assertEquals(187, enchanter.getHealth()); // make sure enemy attack goes down
    }

    @Test
    public void canAttack() {
        enchanter.attack(enemy);
        assertEquals(80, enemy.getHealth()); // make sure warrior health goes down
    }

    @Test
    public void canGetTreasure() {
        enchanter.getTreasure(Treasure.RUBY);
        assertEquals(1, enchanter.getTreasureCount());
    }

    @Test
    public void canCollectReward(){
        enemy.getTreasure(Treasure.RUBY);
        enchanter.collectReward(enemy);
        assertEquals(1, enchanter.getTreasureCount());
    }

    @Test
    public void canGetHealing() {
        enchanter.getHealing(cleric.getItemRestoration());
        assertEquals(215, enchanter.getHealth());
    }

    @Test
    public void isAliveTrue(){
        assertTrue(enchanter.isAlive());
    }

    @Test
    public void isAliveFalse(){
        enchanter.defend(1500);
        assertFalse(enchanter.isAlive());
    }
}
