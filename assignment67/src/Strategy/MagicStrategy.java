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

        // use resource
        self.useResource(3);
    }
}
