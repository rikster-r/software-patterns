package Decorator;

import Hero.IHero;
import Observer.IHeroObserver;

public class HeroDecorator extends IHero {
    protected IHero base;
    protected int roundsLeft;
    protected String effectName;
    public HeroDecorator(IHero base, int rounds, String effectName) {
        super(base.getName());
        this.base = base;
        this.roundsLeft = rounds;
        this.effectName = effectName;
        System.out.println(base.getName() + " uses " + effectName + "! (2 rounds)");
    }

    public void roundPassed() {
        roundsLeft--;
    }
    public boolean expired() {
        return roundsLeft <= 0;
    }
    public int getRoundsLeft() {
        return roundsLeft;
    }
    public String getEffectName() {
        return effectName;
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
    @Override
    public String getHeroType() {
        return base.getHeroType();
    }
    public void notifyPotionEffect(String effectType, String details) {
        for (IHeroObserver observer : base.getObservers()) {
            observer.onPotionEffect(this, effectType, roundsLeft, details);
        }
    }
}
