package Decorator;

import Hero.IHero;

public class ShieldDecorator extends HeroDecorator {
    public ShieldDecorator(IHero base) {
        super(base,2,"Shield Potion");
    }
    public void takeDamage(int damage) {
        if (roundsLeft > 0) {
            notifyPotionEffect("Shield", "blocked part of the damage");
            base.takeDamage((int) damage - 7);
        } else {
            base.takeDamage(damage);
        }
    }
    @Override
    public void act(IHero target) {
        base.act(target);
    }
    @Override
    public void roundPassed() {
        super.roundPassed();
    }



}
