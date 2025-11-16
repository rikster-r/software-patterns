package Observer;

import Hero.*;
import Strategy.*;

public class HeroObserver implements IHeroObserver{
    @Override
    public void onDamageTaken(IHero self, int damage, int remainingHealth, int maxHealth) {
        System.out.println(self.getName() + " took " + damage + " damage! Remaining HP: " + remainingHealth + "/" + maxHealth);
    }

    @Override
    public void onHeal(IHero self, int healAmount, int newHealth, int maxHealth) {
        System.out.println(self.getName() + " healed for " + healAmount + "! Remaining HP: " + newHealth + "/" + maxHealth);
    }

    @Override
    public void onResourceUsed(IHero self, int amount, int remainingResource, int maxResource) {
        System.out.println(self.getName() + " used " + amount + " " + self.getResourceName(amount > 1) + ". Remaining: " + remainingResource + "/" + maxResource);
    }
    @Override
    public void onPotionEffect(IHero hero, String effectType, int roundsLeft, String details) {
        System.out.println(hero.getName() + " [" + effectType + "] " + details
            + (roundsLeft >= 0 ? (" | Potion left: " + roundsLeft + " round(s)") : ""));
    }

    @Override
    public void onResourceReplenished(IHero self, int amount, int newAmount, int maxAmount) {
        System.out.println(self.getName() + " restored " + amount + " " + self.getResourceName() + ". Total: " + newAmount + "/" + maxAmount);
    }

    @Override
    public void onActionPerformed(IHero self, IHero target, IStrategy strategy) {
        if (strategy instanceof DefenseStrategy) return;

        String action = "";

        if (strategy instanceof MeleeStrategy) {
            if (self instanceof Warrior) {
                action = "swung their sword at";
            } else if (self instanceof Archer){
                action = "stabbed";
            }
        } else if (strategy instanceof RangedStrategy) {
            if (self instanceof Archer) {
                action = "shot their bow at ";
            } else if (self instanceof Warrior) {
                action = "threw his weapon at";
            } else if (self instanceof Mage) {
                action = "shot projectile missile at";
            }
        } else if (strategy instanceof MagicStrategy) {
            if (self instanceof Mage) {
                action = "cast a spell on";
            }
        }

        System.out.println(self.getName() + " " + action + " " + target.getName());
    }
    
    @Override
    public void onStrategyChanged(IHero self, IStrategy newStrategy, IStrategy oldStrategy) {
        String action = "";

        if (newStrategy instanceof MeleeStrategy) {
            if (self instanceof Warrior) {
                action = "unsheathed his sword, ready for close combat.";
            } else if (self instanceof Archer) {
                action = "pulled out a dagger for a close skirmish.";
            }
        } else if (newStrategy instanceof RangedStrategy) {
            if (self instanceof Archer) {
                action = "readied the bow and aimed from afar.";
            } else if (self instanceof Warrior) {
                action = "threw his weapon-hand into position for a ranged strike.";
            } else if (self instanceof Mage) {
                action = "began gathering energy for a ranged projectile.";
            }
        } else if (newStrategy instanceof MagicStrategy) {
            action = "started chanting an ancient spell.";
        } else if (newStrategy instanceof DefenseStrategy) {
            action = "took a defensive stance, bracing for impact.";
        }

        System.out.println(self.getName() + " " + action);
    }

    public void onPositionChange(IHero self, int newPos) {
        System.out.println(self.getName() + " changes position to " + newPos);
    }

    @Override
    public void onDeath(IHero self) {
        System.out.println(self.getName() + " has been defeated!");
    }
}