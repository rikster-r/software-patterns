package Hero;

import Strategy.IStrategy;
import Observer.IHeroObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class IHero {
    protected String name;
    protected IStrategy strategy;
    private List<IHeroObserver> observers = new ArrayList<>();

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
        IStrategy oldStrategy = this.strategy;
        this.strategy = strategy;
        notifyStrategyChanged(strategy, oldStrategy);
    }

    // observer handling
    public void addObserver(IHeroObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IHeroObserver observer) {
        observers.remove(observer);
    }

    public void notifyDamageTaken(int damage, int remainingHealth) {
        for (IHeroObserver observer : observers) {
            observer.onDamageTaken(this, damage, remainingHealth, getMaxHealth());
        }
    }

    public void notifyHeal(int healAmount, int newHealth) {
        for (IHeroObserver observer : observers) {
            observer.onHeal(this, healAmount, newHealth, getMaxHealth());
        }
    }

    public void notifyResourceUsed(int amount, int remaining) {
        for (IHeroObserver observer : observers) {
            observer.onResourceUsed(this, amount, remaining, getMaxResource());
        }
    }

    public void notifyResourceReplenished(int amount, int newAmount) {
        for (IHeroObserver observer : observers) {
            observer.onResourceReplenished(this, amount, newAmount, getMaxResource());
        }
    }

    public void notifyActionPerformed(IHero target, IStrategy strategy) {
        for (IHeroObserver observer : observers) {
            observer.onActionPerformed(this, target, strategy);
        }
    }

    public void notifyStrategyChanged(IStrategy newStrategy, IStrategy oldStrategy) {
        for (IHeroObserver observer : observers) {
            observer.onStrategyChanged(this, newStrategy, oldStrategy);
        }
    }

    public void notifyDeath() {
        for (IHeroObserver observer : observers) {
            observer.onDeath(this);
        }
    }

    // health handling
    public abstract int getHealth();
    protected abstract void setHealth(int value);
    public abstract int getMaxHealth();

    public void takeDamage(int damage) {
        int oldHealth = getHealth();
        setHealth(oldHealth - damage);
        if (getHealth() < 0) setHealth(0);

        notifyDamageTaken(damage, getHealth());

        if (getHealth() == 0 && oldHealth > 0) {
            notifyDeath();
        }
    }

    public void heal(int amount) {
        int oldHealth = getHealth();
        setHealth(oldHealth + amount);
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }

        int actualHeal = getHealth() - oldHealth;
        if (actualHeal > 0) {
            notifyHeal(actualHeal, getHealth());
        }
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void act(IHero target) {
        notifyActionPerformed(target, strategy);
        strategy.act(this, target);
    }

    // movement handling
    public abstract void move();

    // resource handling
    public abstract int getResource();
    public abstract String getResourceName(boolean plural);
    // default version - singular by default
    public String getResourceName() {
        return getResourceName(false);
    }
    public abstract int getMaxResource();
    public abstract void useResource(int amount);
    public abstract void replenishResource(int amount);
}