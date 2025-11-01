package Strategy;

import Hero.*;

public class DefenseStrategy implements IStrategy {
    @Override
    public void act(IHero self, IHero target) {
        if (self instanceof Mage) {
            self.replenishResource(5); // mana
            self.notifyResourceReplenished(5, self.getResource());
        } else if (self instanceof Warrior) {
            self.replenishResource(14); // stamina
            self.notifyResourceReplenished(14, self.getResource());
        } else if (self instanceof Archer) {
            self.replenishResource(8); // arrows
            self.notifyResourceReplenished(8, self.getResource());
        }
    }

    @Override
    public int getResourceCost(IHero self) {
        return 0;
    }
}
