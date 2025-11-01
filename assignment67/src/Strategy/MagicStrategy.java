package Strategy;

import Hero.*;

public class MagicStrategy implements IStrategy {
    @Override
    public void act(IHero self, IHero target) {
        // only mage can use this
        if (!(self instanceof Mage)) {
            return;
        }

        int damage = 25; // base magic damage

        if (target.getStrategy() instanceof DefenseStrategy) {
            damage = Math.round(damage * 0.6f);
        }

        target.takeDamage(damage);

        self.useResource(3);
        self.notifyResourceUsed(3, self.getResource());
    }

    @Override
    public int getResourceCost(IHero self) {
        if (self instanceof Mage) {
            return 3;
        }

        return Integer.MAX_VALUE;
    }
}
