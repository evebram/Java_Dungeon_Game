import characters.Cleric;
import characters.Enchanter;
import characters.Entity;
import characters.Warrior;
import rooms.Room;
import stats.*;

import java.util.ArrayList;

public class Quest {

    private int dungeonLength;
    private ArrayList<Room> quest;
    private ArrayList<Entity> party;
    private Entity adventurer1;
    private Entity adventurer2;
    private Entity adventurer3;

    public Quest(int dungeonLength){
        this.dungeonLength = dungeonLength;
        quest = new ArrayList<Room>();
        party = new ArrayList<Entity>();
        this.adventurer1 = new Cleric(Name.getRandomName(), Race.getRandomRace(), 80, HealingItem.getRandomItem());
        this.adventurer2 = new Warrior(Name.getRandomName(), Race.getRandomRace(), 160, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.adventurer3 = new Enchanter(Name.getRandomName(), Race.getRandomRace(), 120, Familiar.getRandomFamiliar(), Spell.getRandomSpell());
    }

    public void generateParty(){
        this.party.add(adventurer1);
        this.party.add(adventurer2);
        this.party.add(adventurer3);
    }

}
