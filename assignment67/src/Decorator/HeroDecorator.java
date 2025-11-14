package Decorator;

import Hero.IHero;

public class HeroDecorator extends IHero {
    protected IHero base;
    public HeroDecorator(IHero base) {
        super(base.getName());
        this.base = base;
    }
    public int getHealth() {
        return base.getHealth();
    }
    public void setHealth(int value) {
        base.setHealth(value);
    }
    public String getEmoji() {
        return base.getEmoji();
    }
    public int getResource() {
        return base.getResource();
    }
    public String getResourceName(boolean plural) {
        return base.getResourceName(plural);
    }
    public int getMaxResource() {
        return base.getMaxResource();
    }
    public int getMaxHealth() {
        return base.getMaxHealth();
    }
    public void useResource(int amount) {
        base.useResource(amount);
    }
    public void replenishResource(int amount) {
        base.replenishResource(amount);
    }
    public int getPosition() {
        return base.getPosition();
    }
    public int getMaxPosition() {
        return base.getMaxPosition();
    }
    public int getMinPosition() {
        return base.getMinPosition();
    }
    public void setPosition(int newPosition) {
        base.setPosition(newPosition);
    }
    public boolean isAlive() {
        return base.isAlive();
    }
    public IHero getBase() {
        return base;
    }
}
