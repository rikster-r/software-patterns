package Hero;

public class HeroFactory {
    public IHero makeHero(String heroType, String heroName) {
        return switch (heroType.toLowerCase()) {
            case "warrior" -> new Warrior(heroName);
            case "mage" -> new Mage(heroName);
            case "archer" -> new Archer(heroName);
            default -> throw new IllegalArgumentException("Hero type not recognized: " + heroType);
        };
    }
}
