package Observer;

import Hero.IHero;
import Strategy.IStrategy;

public interface IHeroObserver {
    void onDamageTaken(IHero self, int damage, int remainingHealth);
    void onHeal(IHero self, int healAmount, int newHealth);
    void onResourceUsed(IHero self, int amount, int remaining);
    void onResourceReplenished(IHero self, int amount, int newAmount);
    void onActionPerformed(IHero self, IHero target, IStrategy strategy);
    void onStrategyChanged(IHero self, IStrategy newStrategy, IStrategy oldStrategy);
    void onDeath(IHero self);
}
