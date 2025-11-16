package Decorator;

import Hero.IHero;

public class PoisonDecorator extends HeroDecorator {
    public PoisonDecorator(IHero base, int rounds){
        super(base,rounds);
    }
    @Override
    public void takeDamage(int damage) {
        base.takeDamage(damage);
    }
    @Override
    public void act(IHero target) {
        base.act(target);
    }
    @Override
    public void roundPassed() {
        super.roundPassed();
        base.takeDamage(7);
    }
}
