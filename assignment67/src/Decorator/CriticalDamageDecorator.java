package Decorator;

import Hero.IHero;
import Strategy.IStrategy;
import Strategy.MagicStrategy;
import Strategy.MeleeStrategy;
import Strategy.RangedStrategy;

public class CriticalDamageDecorator extends HeroDecorator  {
    public CriticalDamageDecorator(IHero base, int rounds) {
        super(base,rounds);
    }
    public void act(IHero target) {
        IStrategy strategy = base.getStrategy();
        int damage = 0;
        if (strategy instanceof MeleeStrategy) {
            if (base instanceof Hero.Warrior)
                damage = (int)(20*1.5);
            if (base instanceof Hero.Archer)
                damage = (int)(15*1.5);
        }
        if (strategy instanceof RangedStrategy) {
            if (base instanceof Hero.Archer)
                damage = (int)(20*1.5);
            if (base instanceof Hero.Warrior)
                damage = (int)(10*1.5);
            if (base instanceof Hero.Mage)
                damage = (int)(15*1.5);
        }
        if (strategy instanceof MagicStrategy) {
            if (base instanceof Hero.Mage)
                damage = (int)(25*1.5);
        }
        if (damage > 0) {
            target.takeDamage(damage);
            int cost = strategy.getResourceCost(base);
            base.useResource(cost);
            base.notifyResourceUsed(cost, base.getResource());
        } else {
            base.act(target);
        }
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
