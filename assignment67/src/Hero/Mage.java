package Hero;

public class Mage extends IHero {
    private static final int MAX_HEALTH = 150;
    private static final int MAX_MANA = 10;

    private int health = MAX_HEALTH;
    private int mana = MAX_MANA;

    public Mage(String name) {
        super(name);
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public String getEmoji() {
        return "\uD83E\uDDD9";
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    protected void setHealth(int value) {
        this.health = value;
    }

    @Override
    public int getResource() {
        return mana;
    }

    @Override
    public String getResourceName(boolean plural) {
        return "mana";
    }

    @Override
    public int getMaxResource() {
        return MAX_MANA;
    }

    @Override
    public void useResource(int amount) {
        mana -= amount;
        if (mana < 0) mana = 0;
    }

    @Override
    public void replenishResource(int amount) {
        mana += amount;
        if (mana > MAX_MANA) mana = MAX_MANA;
    }
}
