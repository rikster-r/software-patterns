package Hero;

import Strategy.IStrategy;

public abstract class IHero {
    protected String name;
    protected IStrategy strategy;

    public IHero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    // health handling
    public abstract int getHealth();
    protected abstract void setHealth(int value);
    public abstract int getMaxHealth();

    public void takeDamage(int damage) {
        int newHealth = getHealth() - damage;
        if (newHealth < 0) newHealth = 0;
        setHealth(newHealth);
    }

    public void heal(int heal) {
        int newHealth = getHealth() + heal;
        if (newHealth > getMaxHealth()) newHealth = getMaxHealth();
        setHealth(newHealth);
    }

    public void act(IHero self, IHero target) {
        strategy.act(self, target);
    }

    public abstract void move();
    public abstract void useResource(int amount);
    public abstract void replenishResource(int amount);
}
