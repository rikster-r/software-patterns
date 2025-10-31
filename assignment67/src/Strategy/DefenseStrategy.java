package Strategy;

import Hero.*;

public class DefenseStrategy implements IStrategy {
    @Override
    public void act(IHero self, IHero target) {
        if (self instanceof Mage) {
            self.replenishResource(5); // mana
        } else if (self instanceof Warrior) {
            self.replenishResource(14); // stamina
        } else if (self instanceof Archer) {
            self.replenishResource(8); // arrows
        }
    }
}
