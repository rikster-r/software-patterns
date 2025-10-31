package Hero;

public class Warrior extends IHero {
    protected static final int MAX_HEALTH = 100;
    protected static final int MAX_STAMINA = 30;

    private int health = MAX_HEALTH;
    // max - 30
    private int stamina = MAX_STAMINA;


    public Warrior(String name) {
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
        stamina -= amount;
    }

    @Override
    public void replenishResource(int amount) {
        stamina += amount;
    }
}
