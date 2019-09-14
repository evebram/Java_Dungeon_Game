package stats;

import java.util.Random;

    public enum Dungeon {
        DUNGEON1(1),
        DUNGEON2(2),
        DUNGEON3(3);

        private final int contents;

        private static final Dungeon[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        Dungeon(int contents) {
            this.contents = contents;
        }

        public int getContents() {
            return contents;
        }

        public static Dungeon getRandomDungeon() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }

    }
