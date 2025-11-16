package Decorator;

import Hero.IHero;

import java.util.Random;

public class MissDecorator extends HeroDecorator {
    private Random random = new Random();
    public MissDecorator(IHero base) {
        super(base, 2, "Miss Potion");
    }
    @Override
    public void act(IHero target) {
        if (roundsLeft > 0 && random.nextInt(100) < 30) {
            notifyPotionEffect("Miss", "missed!");
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
