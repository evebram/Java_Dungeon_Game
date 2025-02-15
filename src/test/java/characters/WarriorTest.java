package characters;

import stats.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {

    Warrior warrior;
    Enemy enemy;
    Cleric cleric;

    @Before
    public void setUp() {
        warrior = new Warrior(Name.BEATRICE, Race.HALFLING, 400,  Armour.HELMET, Weapon.CLUB);
        enemy = new Enemy(Name.IZZY, Race.GOBLIN, 100, Armour.HELMET, Weapon.CLUB);
        cleric = new Cleric(Name.STACY, Race.ORC, 150, HealingItem.POTION);
    }

    @Test
    public void hasName() {
        assertEquals(Name.BEATRICE, warrior.getName());
    }

    @Test
    public void hasRace() {
        assertEquals(Race.HALFLING, warrior.getRace());
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
    public void canChangeArmour() {
        warrior.changeArmour(Armour.CUIRASS);
        assertEquals(Armour.CUIRASS, warrior.getArmour());
    }

    @Test
    public void canChangeWeapon() {
        warrior.changeWeapon(Weapon.SWORD);
        assertEquals(Weapon.SWORD, warrior.getWeapon());
    }

    @Test
    public void canDefend() {
        warrior.defend(40);
        assertEquals(387, warrior.getHealth()); // make sure enemy attack goes down
    }

    @Test
    public void canAttack() {
        warrior.attack(enemy);
        assertEquals(40, enemy.getWeaponDamage());
    }

    @Test
    public void canCollectReward(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        warrior.collectReward(enemy);
        assertEquals(1, warrior.inventory.getTreasureCount());
    }

    @Test
    public void canGetTotalLoot(){
        enemy.inventory.getTreasure(Treasure.RUBY);
        warrior.collectReward(enemy);
        assertEquals(10, warrior.getTotalLoot());
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
