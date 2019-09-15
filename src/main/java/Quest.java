import characters.*;
import rooms.Room;
import stats.*;

import java.util.ArrayList;

public class Quest {

    private int dungeonLength;
    private ArrayList<Room> quest;
    private ArrayList<Entity> party;
    private Room room;
    private Entity adventurer1;
    private Entity adventurer2;
    private Entity adventurer3;
    private Enemy enemy;

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

    public void generateQuest(){
        for(int i = 0; i < dungeonLength; i++) {
           // room.generateEnemy();
            room = new Room(Dungeon.getRandomDungeon());
            room.generateEnemy();
            quest.add(room);
           // quest.get(i).generateEnemy();
        }
    }

    public int getQuestLength(){
        return quest.size();
    }

    public int getQuestRoom(int i){
        return quest.get(i).returnCombatantsInventory();
    }

    public int getPartySize(){
        return party.size();
    }

    public int getPartyStats(int i){
        return party.get(i).getHealth();
    }

//    public boolean runQuest(){
//        generateParty();
//        generateQuest();
//        for(int i = 0; i < dungeonLength; i++) {
//           if(quest.get(i).isRoomComplete())
//               return true;
//        }
//        return false;
//    }
//
//    public String isQuestComplete(){
//        if (runQuest()) {
//            return "Quest completed!";
//        } else{
//            return "Quest failed";
//        }
//    }

}
