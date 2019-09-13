package items;

public enum HealingItem {

    HERBS(10),
    POTION(15),
    HEALINGPRAYER(20);

    private final int restore;

    HealingItem(int restore) {
        this.restore = restore;
    }

    public int getRestoration() {
        return restore;
    }
}
