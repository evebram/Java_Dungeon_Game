package items;

import java.util.Random;

public enum Treasure {

    RUBY(10),
    GOLD(4),
    SPOON(1);

    private final int worth;

    private static final Treasure[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    Treasure(int worth){
         this.worth = worth;
     }

     public int getWorth(){
        return worth;
     }

     public static Treasure getRandomTreasure(){
        return VALUES[RANDOM.nextInt(SIZE)];
     }

}
