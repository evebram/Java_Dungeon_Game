package inventory;

import stats.Treasure;
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Treasure> inventory;

    public Inventory() {
        this.inventory = new ArrayList<Treasure>();
    }

    public void getTreasure(Treasure item) {
        inventory.add(item);
    }

    public int getTreasureCount() {
        return inventory.size();
    }

    public Treasure removeItem() {
        return inventory.remove(0);
    }

    public int getInventoryWorth() {
        int totalValue = 0;
        for (int i = 0; i < inventory.size(); i++){
            totalValue += inventory.get(i).getWorth();
        }
        return totalValue;
    }

    public int getInventorySize() {
        return inventory.size();
    }
}
