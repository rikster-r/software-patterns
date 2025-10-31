package Hero;

public class Mage extends IHero {
    protected static final int MAX_HEALTH = 100;
    protected static final int MAX_MANA = 10;

    private int mana = MAX_HEALTH;
    // max - 10
    private int health = MAX_MANA;


    public Mage(String name) {
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
        mana -= amount;
    }

    @Override
    public void replenishResource(int amount) {
        mana += amount;
    }
}
