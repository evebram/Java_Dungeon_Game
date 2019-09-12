package characters;

import items.Armour;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    Enemy enemy;
    Warrior warrior;

    @Before
    public void setUp() {
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);
        warrior = new Warrior("Eve", "Dwarf", 400, Armour.HELMET, Weapon.CLUB);
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
        enemy.defend(warrior);
        assertEquals();
    }

    @Test
    public void canAttack() {
        enemy.attack(warrior);
        assertEquals();
    }




}

