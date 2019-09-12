package characters;

public abstract class Entity {

    private String name;
    private String type;
    private int health;
//    private ArrayList<treasure> inventory;

    public Entity(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
//        this.inventory = new ArrayList<treasure>();
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }
}
