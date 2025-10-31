package Strategy;

import Hero.*;

public class MeleeStrategy implements IStrategy {
    @Override
    public void act(IHero self, IHero target) {
        // only Warrior and Archer can use this
        if (self instanceof Mage) {
            return;
        }

        // calculate damage
        int damage = 0;

        if (self instanceof Warrior) {
            damage = 20;
        } else if (self instanceof Archer) {
            damage = 15;
        }

        if (target.getStrategy() instanceof DefenseStrategy) {
            damage = Math.round(damage * 0.6f);
        }

        target.takeDamage(damage);

        // use resource
        if (self instanceof Warrior) {
            self.useResource(6);
        }
    }
}
