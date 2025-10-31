package Hero;

public class Archer extends IHero {
    protected static final int MAX_HEALTH = 135;
    protected static final int MAX_ARROWS = 15;

    private int health = MAX_HEALTH;
    private int arrows = MAX_ARROWS;

    public Archer(String name) {
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
    public void useResource(int amount) {
        arrows -= amount;
        if (arrows < 0) arrows = 0;
    }

    @Override
    public void replenishResource(int amount) {
        arrows += amount;
        if (arrows > MAX_ARROWS) arrows = MAX_ARROWS;
    }
}
