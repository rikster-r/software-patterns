package Visitor;

import Decorator.HeroDecorator;
import Hero.Archer;
import Hero.Mage;
import Hero.Warrior;

public interface IHeroVisitor {
    void visit(Warrior warrior);
    void visit(Mage warrior);
    void visit(Archer warrior);
    void visit(HeroDecorator warrior);
}
