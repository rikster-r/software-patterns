class CoffeeFactory {
    public Coffee createCoffee(String coffeeType) {
        if (coffeeType.equalsIgnoreCase("Espresso")) {
            return new Espresso();
        }
        else if (coffeeType.equalsIgnoreCase("Latte")) {
            return new Latte();
        } else {
            throw new IllegalArgumentException("Invalid coffee type: " + coffeeType);
        }
    }
}