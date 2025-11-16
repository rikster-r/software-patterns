package Decorator;

import Hero.IHero;

public class PoisonDecorator extends HeroDecorator {
    public PoisonDecorator(IHero base){
        super(base, 2, "Poison Potion");
    }
    @Override
    public void roundPassed() {
        super.roundPassed();
        if (roundsLeft > 0) {
            notifyPotionEffect("Poison", "took damage by 9; HP = " + (getHealth() - 9));
            base.takeDamage(9);
        }
    }
    @Override
    public void act(IHero target) {
        base.act(target);
    }

}
