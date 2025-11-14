package Hero;

public class HeroBuilder {
    public static Archer.Builder archer() {
        return new Archer.Builder();
    }
    public static Mage.Builder mage() {
        return new Mage.Builder();
    }
    public static Warrior.Builder warrior() {
        return new Warrior.Builder();
    }
}
