package Hero;

// each hero implements its own resource - mana for mage, stamina for warrior, arrows for archer
public abstract class IHero {
    protected String name;
    protected int health;

    public IHero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void act();
    public abstract void move();
    public abstract void useResource(int amount);
    public abstract void replenishResource(int amount);
}
