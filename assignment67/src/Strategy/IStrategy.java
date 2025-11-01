package Strategy;

import Hero.IHero;

public interface IStrategy {
    void act(IHero self, IHero target);
    int getResourceCost(IHero self);
}
