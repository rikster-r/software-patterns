package Decorator;

import Hero.IHero;
import Strategy.IStrategy;
import Strategy.MagicStrategy;
import Strategy.MeleeStrategy;
import Strategy.RangedStrategy;

public class CriticalDamageDecorator extends HeroDecorator  {
    public CriticalDamageDecorator(IHero base) {
        super(base, 2, "Critical Damage");
    }
    @Override
    public void act(IHero target) {
        if (roundsLeft > 0) {
            IStrategy strategy = base.getStrategy();
            int damage = 0;
            boolean crit = false;
            if (strategy instanceof MeleeStrategy) {
                if (base instanceof Hero.Warrior) {
                    damage = (int) (20 * 1.5);
                    crit = true;
                }
                if (base instanceof Hero.Archer) {
                    damage = (int) (15 * 1.5);
                    crit = true;
                }
            }
            if (strategy instanceof RangedStrategy) {
                if (base instanceof Hero.Archer) {
                    damage = (int) (20 * 1.5);
                    crit = true;
                }
                if (base instanceof Hero.Warrior) {
                    damage = (int) (10 * 1.5);
                    crit = true;
                }
                if (base instanceof Hero.Mage) {
                    damage = (int) (15 * 1.5);
                    crit = true;
                }
            }
            if (strategy instanceof MagicStrategy) {
                if (base instanceof Hero.Mage) {
                    damage = (int) (25 * 1.5);
                    crit = true;
                }
            }
            if (crit) {
                notifyPotionEffect("Critical Damage", "attacked with Crit Damage");
                target.takeDamage(damage);
                int cost = strategy.getResourceCost(base);
                base.useResource(cost);
                base.notifyResourceUsed(cost, base.getResource());
            } else {
                base.act(target);
            }
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
