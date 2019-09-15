package characters;

import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClericTest {

    Cleric cleric;
    Enchanter enchanter;
    Enemy enemy;
    Warrior warrior;

    @Before
    public void setUp() {
        cleric = new Cleric(Name.IZZY, Race.ORC, 150, HealingItem.POTION);
        enchanter = new Enchanter(Name.DENICE, Race.DWARF, 200, Familiar.OWL, Spell.FIREBALL);
        enemy = new Enemy(Name.MELISSA, Race.GNOME, 100, Armour.CUIRASS, Weapon.CLUB);
        warrior = new Warrior(Name.BARRY, Race.HUMAN, 0,Armour.GAUNTLETS, Weapon.AXE);
    }

    @Test
    public void hasName() {
        assertEquals(Name.IZZY, cleric.getName());
    }

    @Test
    public void hasRace() {
        assertEquals(Race.ORC, cleric.getRace());
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
    public void canChangeHealingItem() {
        cleric.changeHealingItem(HealingItem.HEALINGPRAYER);
        assertEquals(HealingItem.HEALINGPRAYER, cleric.getHealingItem());
    }

    @Test
    public void canDefend() {
        cleric.defend(enemy.getWeaponDamage());
        assertEquals(110, cleric.getHealth());
    }

    @Test
    public void canHeal() {
        cleric.heal(enchanter);
        assertEquals(215, enchanter.getHealth());
    }

    public void canNotHeal(){
        cleric.heal(warrior);
        assertEquals(0, warrior.getHealth());
    }

    @Test
    public void canCollectReward(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        cleric.collectReward(enemy);
        assertEquals(1, cleric.inventory.getTreasureCount());
    }

    @Test
    public void canGetTotalLoot(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        cleric.collectReward(enemy);
        assertEquals(10, cleric.getTotalLoot());
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
