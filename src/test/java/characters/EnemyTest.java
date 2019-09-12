package characters;

import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    Enemy enemy;

    @Before
    public void setUp() {
        enemy = new Enemy("Ben", "Troll", 100, Weapon.CLUB);

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




}

