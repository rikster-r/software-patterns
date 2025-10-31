package Hero;

public class HeroFactory {
    IHero makeHero(String heroType, String heroName) {
        if (heroType.equalsIgnoreCase("Warrior")) {
            return new Warrior(heroName);
        } else if (heroType.equalsIgnoreCase("Mage")) {
            return new Mage(heroName);
        } else if (heroType.equalsIgnoreCase("Archer")) {
            return new Archer(heroName);
        } else {
            throw new IllegalArgumentException("Hero Type not recognized");
        }
    }
}
