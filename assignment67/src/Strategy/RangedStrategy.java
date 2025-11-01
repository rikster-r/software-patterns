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

        if (self instanceof Mage) {
            self.useResource(1); // mana
            self.notifyResourceUsed(1, self.getResource());
        } else {
            self.useResource(4); // stamina
            self.notifyResourceUsed(4, self.getResource());
        }
    }

    @Override
    public int getResourceCost(IHero self) {
        if (self instanceof Archer) {
            return 4;
        }

        if (self instanceof Warrior) {
            return 4;
        }

        if (self instanceof Mage) {
            return 1;
        }

        return 0;
    }
}
