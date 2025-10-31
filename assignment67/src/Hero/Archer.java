package Hero;

public class Archer extends IHero {
    protected static final int MAX_HEALTH = 100;
    protected static final int MAX_ARROWS = 15;

    private int health = MAX_HEALTH;
    // max - 15
    private int arrows = MAX_ARROWS;


    public Archer(String name) {
        super(name);
    }

    @Override
    public void act() {

    }

    @Override
    public void move() {

    }

    @Override
    public void useResource(int amount) {
        arrows -= amount;
    }

    @Override
    public void replenishResource(int amount) {
        arrows += amount;
    }
}
