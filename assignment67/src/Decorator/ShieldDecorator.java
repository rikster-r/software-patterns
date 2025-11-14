package Decorator;

import Hero.IHero;

public class ShieldDecorator extends HeroDecorator {
    public ShieldDecorator(IHero base) {
        super(base);
    }
    public void takeDamage(int damage) {
        base.takeDamage((int) (damage * 0.6));
    }
}
