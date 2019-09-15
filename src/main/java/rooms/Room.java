package rooms;

import characters.Enemy;
import stats.*;

import java.util.ArrayList;
import java.util.Random;

public class Room {

    private Dungeon dungeon;
    private Enemy enemy;
    private ArrayList<Enemy> adversaries;
    private ArrayList<Enemy> combatants;

    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;

    public Room(Dungeon dungeon) {
        this.dungeon = dungeon;
        this.adversaries = new ArrayList<Enemy>();
        this.combatants = new ArrayList<Enemy>();


        this.enemy1 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 100, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy2 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 140, Armour.getRandomArmour(), Weapon.getRandomWeapon());
        this.enemy3 = new Enemy(Name.getRandomName(), Race.getRandomRace(), 160, Armour.getRandomArmour(), Weapon.getRandomWeapon());

        this.adversaries.add(enemy1);
        this.adversaries.add(enemy2);
        this.adversaries.add(enemy3);

    }

    public void addEnemyToCombatants(Enemy enemy) {
        this.combatants.add(enemy);
    }

//    public void generateRoom(){
//        Room room = new Room(Dungeon.getRandomDungeon());
//        for (int i = 0; i < dungeon.getContents(); i++){
//            enemy = new Enemy(Name.getRandomName(), Race.getRandomRace(), 120, Armour.getRandomArmour(), Weapon.getRandomWeapon());
//            this.combatants.add(enemy);
//            combatants.get(i).generateInventory();
//        }
//    }

    public void generateEnemy() {
        this.getRandomElement(adversaries, dungeon.getContents());
        for (int i = 0; i < combatants.size(); i++) {
            combatants.get(i).generateInventory();
        }
    }

    //select an enemy based on index from adversaries arrayList and return to combatants arrayList
    public void getRandomElement(ArrayList<Enemy> adversaries, int totalEnemies) {
        Random rand = new Random();
        for (int i = 0; i < totalEnemies; i++) {
            //take a random index between 0 and size of given arrayList
            int randomIndex = rand.nextInt(adversaries.size());
            //add enemy to combatants arrayList
            combatants.add(adversaries.get(randomIndex));
            //remove selected enemy from adversaries arrayList
            adversaries.remove(randomIndex);
        }
        //return combatants;
    }

    public int getCombatantsTotal() {
        return combatants.size();
    }

    public int getAdversariesTotal() {
        return adversaries.size();
    }

    public int returnCombatantsInventory() {
        return combatants.get(0).getInventorySize();
    }

    public boolean isComplete() {
        for (int i = 0; i < combatants.size(); i++) {
            if (!combatants.get(i).isAlive())
            return true;
        }
        return false;
    }
}

