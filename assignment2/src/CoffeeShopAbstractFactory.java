interface CafeFactory {
    Coffee createCoffee();
    Dessert createDessert();
}

class ItalianCafeFactory implements CafeFactory {
    private final CoffeeFactory coffeeFactory = new EspressoFactory();
    private final DessertFactory dessertFactory = new TiramisuFactory();

    public Coffee createCoffee() { return coffeeFactory.createCoffee(); }
    public Dessert createDessert() { return dessertFactory.createDessert(); }
}

class AmericanCafeFactory implements CafeFactory {
    private final CoffeeFactory coffeeFactory = new LatteFactory();
    private final DessertFactory dessertFactory = new DonutFactory();

    public Coffee createCoffee() { return coffeeFactory.createCoffee(); }
    public Dessert createDessert() { return dessertFactory.createDessert(); }
}