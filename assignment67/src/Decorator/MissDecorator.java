package Decorator;

import Hero.IHero;

import java.util.Random;

public class MissDecorator extends HeroDecorator {
    private Random random = new Random();
    public MissDecorator(IHero base, int rounds) {
        super(base,rounds);
    }
    @Override
    public void act(IHero target) {
        if (random.nextInt(100) < 30) {
            System.out.println(getName() + " missed!");
            return;
        }
        base.act(target);

    }
    @Override
    public void takeDamage(int damage) {
        base.takeDamage(damage);
    }
    @Override
    public void roundPassed() {
        super.roundPassed();
    }
}
