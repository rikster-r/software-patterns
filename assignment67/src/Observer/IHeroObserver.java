package Observer;

import Hero.IHero;
import Strategy.IStrategy;

public interface IHeroObserver {
    void onDamageTaken(IHero self, int damage, int remainingHealth, int maxHealth);
    void onHeal(IHero self, int healAmount, int newHealth, int maxHealth);
    void onResourceUsed(IHero self, int amount, int remainingResource, int maxResource);
    void onResourceReplenished(IHero self, int amount, int newAmount, int maxAmount);
    void onActionPerformed(IHero self, IHero target, IStrategy strategy);
    void onStrategyChanged(IHero self, IStrategy newStrategy, IStrategy oldStrategy);
    void onPositionChange(IHero self, int newPos);
    void onDeath(IHero self);
    void onPotionEffect(IHero hero, String effectType, int roundsLeft, String details);

}
