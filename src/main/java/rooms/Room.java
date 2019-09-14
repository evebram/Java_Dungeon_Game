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

    public Room(Dungeon dungeon){
        this.dungeon = dungeon;
        this.adversaries = new ArrayList<Enemy>();
        this.combatants = new ArrayList<Enemy>();
    }

    public void addEnemyToAdversaries(Enemy enemy){
        this.adversaries.add(enemy);
    }

    public void generateEnemy(){
        this.getRandomElement(adversaries, dungeon.getContents());
        for(int i = 0; i < combatants.size(); i++){
            enemy = new Enemy(Name.getRandomName(), Race.getRandomRace(), 200, Armour.getRandomArmour(), Weapon.getRandomWeapon());
            enemy.generateInventory();
        }
    }

    //select an enemy based on index from adversaries arrayList and return to combatants arrayList
    public void getRandomElement(ArrayList<Enemy> adversaries, int totalEnemies){
        Random rand = new Random();
        for(int i = 0; i < totalEnemies; i++) {
            //take a random index between 0 and size of given arrayList
            int randomIndex = rand.nextInt(adversaries.size());
            //add element to combatants arrayList
            combatants.add(adversaries.get(randomIndex));
            //remove selected enemy from adversaries arrayList
            adversaries.remove(randomIndex);
        }
        //return combatants;
    }

    public int getCombatantsTotal(){
        return combatants.size();
    }

    public int getAdversariesTotal(){
        return adversaries.size();
    }

    public int returnCombatantsInventory(){
        return combatants.get(0).getInventorySize();
    }



}
