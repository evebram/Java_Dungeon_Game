package items;

public enum HealingItem {
    HERBS(5),
    POTION(10),
    PRAYEROFHEALING(15);

    private final int healing;

    HealingItem(int healing) {
        this.healing = healing;
    }

    public int getHealing() {
        return this.healing;
    }
}
