package characters;

import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnchanterTest {

    Enchanter enchanter;
    Enemy enemy;
    Cleric cleric;

    @Before
    public void setUp() {
        cleric = new Cleric(Name.IZZY, Race.ORC, 150, HealingItem.POTION);
        enchanter = new Enchanter(Name.DENICE, Race.DWARF, 200, Familiar.OWL, Spell.FIREBALL);
        enemy = new Enemy(Name.MELISSA, Race.GNOME, 100, Armour.CUIRASS, Weapon.CLUB);
    }

    @Test
    public void hasName() {
        assertEquals(Name.DENICE, enchanter.getName());
    }

    @Test
    public void hasRace() {
        assertEquals(Race.DWARF, enchanter.getRace());
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
    public void canChangeFamiliar() {
        enchanter.changeFamiliar(Familiar.TOAD);
        assertEquals(Familiar.TOAD, enchanter.getFamiliar());
    }

    @Test
    public void canChangeSpell() {
        enchanter.changeSpell(Spell.FROSTBITE);
        assertEquals(Spell.FROSTBITE, enchanter.getSpell());
    }

    @Test
    public void canDefend() {
        enchanter.defend(enemy.getWeaponDamage());
        assertEquals(187, enchanter.getHealth()); // make sure enemy attack goes down
    }

    @Test
    public void canAttack() {
        enchanter.attack(enemy);
        assertEquals(95, enemy.getHealth()); // make sure warrior health goes down
    }

    @Test
    public void canCollectReward(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        enchanter.collectReward(enemy);
        assertEquals(1, enchanter.inventory.getTreasureCount());
    }

    @Test
    public void canGetTotalLoot(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        enchanter.collectReward(enemy);
        assertEquals(10, enchanter.getTotalLoot());
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
