package Hero;

public class Warrior extends IHero {
    protected static final int MAX_HEALTH = 180;
    protected static final int MAX_STAMINA = 20;

    private int health = MAX_HEALTH;
    private int stamina = MAX_STAMINA;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
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
    public void move() {

    }

    @Override
    public int getResource() {
        return stamina;
    }

    @Override
    public String getResourceName(boolean plural) {
        return "stamina";
    }

    @Override
    public int getMaxResource() {
        return MAX_STAMINA;
    }

    @Override
    public void useResource(int amount) {
        stamina -= amount;
        if (stamina < 0) stamina = 0;
    }

    @Override
    public void replenishResource(int amount) {
        stamina += amount;
        if (stamina > MAX_STAMINA) stamina = MAX_STAMINA;
    }
}
