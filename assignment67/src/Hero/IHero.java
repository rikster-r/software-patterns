package Hero;

import Decorator.HeroDecorator;
import Strategy.IStrategy;
import Observer.IHeroObserver;
import Visitor.IHeroVisitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class IHero {
    protected String name;
    protected int position;
    protected static final int MAX_POSITION = 7;
    protected static final int MIN_POSITION = 1;
    protected IStrategy strategy;
    protected Set<String> usedPotions = new HashSet<>();
    private List<IHeroObserver> observers = new ArrayList<>();
    public List<IHeroObserver> getObservers() {
        return observers;
    }
    public IHero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getHeroType() {
        return getClass().getSimpleName();
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        IStrategy oldStrategy = this.strategy;
        this.strategy = strategy;
        notifyStrategyChanged(strategy, oldStrategy);
    }

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

    public void notifyPositionChange(int newPos) {
        for (IHeroObserver observer : observers) {
            observer.onPositionChange(this, newPos);
        }
    }

    public void notifyDeath() {
        for (IHeroObserver observer : observers) {
            observer.onDeath(this);
        }
    }

    // health handling
    public abstract int getHealth();
    public abstract void setHealth(int value);
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

    public boolean isAlive() {
        return getHealth() > 0;
    }
    public boolean hasUsedPotion(String potionName) {
        return usedPotions.contains(potionName);
    }
    public void markPotionUsed(String potionName) {
        usedPotions.add(potionName);
    }

    public void act(IHero target) {
        notifyActionPerformed(target, strategy);
        strategy.act(this, target);
    }

    public int getPosition() {
        return position;
    }

    public int getMaxPosition() {
        return MAX_POSITION;
    }

    public int getMinPosition() {
        return MIN_POSITION;
    }

    public void setPosition(int newPosition) {
        notifyPositionChange(newPosition);
        this.position = newPosition;
    }

    public void accept(IHeroVisitor visitor) {
        if (this instanceof Warrior w) visitor.visit(w);
        else if (this instanceof Mage m) visitor.visit(m);
        else if (this instanceof Archer a) visitor.visit(a);
        else if (this instanceof HeroDecorator h) visitor.visit(h);
    }
    public abstract String getEmoji();
    public abstract int getResource();
    public abstract String getResourceName(boolean plural);
    public String getResourceName() {
        return getResourceName(false);
    }
    public abstract int getMaxResource();
    public abstract void useResource(int amount);
    public abstract void replenishResource(int amount);
}