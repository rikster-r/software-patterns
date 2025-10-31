package Observer;

import Hero.IHero;
import Hero.Mage;
import Hero.Archer;
import Hero.Warrior;
import Strategy.IStrategy;
import Strategy.DefenseStrategy;
import Strategy.MagicStrategy;
import Strategy.MeleeStrategy;
import Strategy.RangedStrategy;

public class HeroObserver implements IHeroObserver{
    @Override
    public void onDamageTaken(IHero self, int damage, int remainingHealth) {
        System.out.println(self.getName() + " took " + damage + " damage! HP: " + remainingHealth);
    }

    @Override
    public void onHeal(IHero self, int healAmount, int newHealth) {
        System.out.println(self.getName() + " healed for " + healAmount + "! HP: " + newHealth);
    }

    @Override
    public void onResourceUsed(IHero self, int amount, int remaining) {
        String resourceType;

        if (self instanceof Mage) {
            resourceType = "mana";
        } else if (self instanceof Archer) {
            resourceType = amount == 1 ? "arrow" : "arrows";
        } else if (self instanceof Warrior) {
            resourceType = "stamina";
        } else {
            resourceType = "resource";
        }

        System.out.println(self.getName() + " used " + amount + " " + resourceType + ". Remaining: " + remaining);
    }

    @Override
    public void onResourceReplenished(IHero self, int amount, int newAmount) {
        String resourceType;

        if (self instanceof Mage) {
            resourceType = "mana";
        } else if (self instanceof Archer) {
            resourceType = amount == 1 ? "arrow" : "arrows";
        } else if (self instanceof Warrior) {
            resourceType = "stamina";
        } else {
            resourceType = "resource";
        }

        System.out.println(self.getName() + " restored " + amount + " " + resourceType + ". Total: " + newAmount);
    }

    @Override
    public void onActionPerformed(IHero self, IHero target, IStrategy strategy) {
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
        } else if (strategy instanceof DefenseStrategy) {
            action = "defended against";
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

    @Override
    public void onDeath(IHero self) {
        System.out.println(self.getName() + " has been defeated!");
    }
}