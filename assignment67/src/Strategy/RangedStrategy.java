package Strategy;

import Hero.*;

public class RangedStrategy implements IStrategy {
    @Override
    public void act(IHero self, IHero target) {
        int damage = 0;

        if (self instanceof Archer) {
            damage = 20;
        } else if (self instanceof Warrior) {
            damage = 10;
        } else if (self instanceof Mage) {
            damage = 15;
        }

        if (target.getStrategy() instanceof DefenseStrategy) {
            damage = Math.round(damage * 0.6f);
        }

        target.takeDamage(damage);

        // use resource
        if (self instanceof Mage) {
            self.useResource(1); // mana
        } else {
            self.useResource(4); // stamina
        }
    }
}
