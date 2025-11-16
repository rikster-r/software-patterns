package Visitor;

import Decorator.HeroDecorator;
import Hero.Archer;
import Hero.Mage;
import Hero.Warrior;

public class HeroStatusVisitor implements IHeroVisitor {
    @Override
    public void visit(Warrior warrior) {
        System.out.println(warrior.getName() + " (Warrior)");
        System.out.println("HP: " + warrior.getHealth() + "/" + warrior.getMaxHealth());
        System.out.println("Stamina " + warrior.getResource() + "/" + warrior.getResource());
        System.out.println("---------------------");
    }
    @Override
    public void visit(Mage mage) {
        System.out.println(mage.getName() + " (Mage)");
        System.out.println("HP: " + mage.getHealth() + "/" + mage.getMaxHealth());
        System.out.println("Mana " + mage.getResource() + "/" + mage.getResource());
        System.out.println("---------------------");
    }
    @Override
    public void visit(Archer archer) {
        System.out.println(archer.getName() + " (Warrior)");
        System.out.println("HP: " + archer.getHealth() + "/" + archer.getMaxHealth());
        System.out.println("Arrows " + archer.getResource() + "/" + archer.getResource());
        System.out.println("---------------------");
    }
    @Override
    public void visit(HeroDecorator decorator) {
        System.out.println(decorator.getBase().getName() + "[Decorator Effect" + decorator.getEffectName() + "]");
        System.out.println("Potions left " + decorator.getRoundsLeft());
        decorator.getBase().accept(this);
    }
}
