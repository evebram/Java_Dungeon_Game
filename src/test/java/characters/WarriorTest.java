package characters;

import items.Armour;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarriorTest {

    Warrior warrior;
    Enemy enemy;

    @Before
    public void setUp() {
        warrior = new Warrior("Eve", "Dwarf", 400, Armour.HELMET, Weapon.CLUB);
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);

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




}
