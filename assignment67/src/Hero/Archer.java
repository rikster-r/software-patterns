package Hero;

public class Archer extends IHero {
    protected static final int MAX_HEALTH = 135;
    protected static final int MAX_ARROWS = 15;

    private int health;
    private int arrows;

    private Archer(Builder builder) {
        super(builder.name);
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public String getEmoji() {
        return "\uD83C\uDFF9";
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int value) {
        this.health = value;
    }

    @Override
    public int getResource() {
        return arrows;
    }

    @Override
    public String getResourceName(boolean plural) {
        return plural ? "arrows" : "arrow";
    }

    @Override
    public int getMaxResource() {
        return MAX_ARROWS;
    }

    @Override
    public void useResource(int amount) {
        arrows -= amount;
        if (arrows < 0) arrows = 0;
    }

    @Override
    public void replenishResource(int amount) {
        arrows += amount;
        if (arrows > MAX_ARROWS) arrows = MAX_ARROWS;
    }
    public static class Builder {
        private String name;
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Archer build() {
            return new Archer(this);
        }
    }
}
