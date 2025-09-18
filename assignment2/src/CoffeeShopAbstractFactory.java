interface CafeFactory {
    Coffee createCoffee();
    Dessert createDessert();
}

class ItalianCafeFactory implements CafeFactory {
    private final CoffeeFactory coffeeFactory = new CoffeeFactory();
    private final DessertFactory dessertFactory = new DessertFactory();

    public Coffee createCoffee() {
        return coffeeFactory.createCoffee("Espresso");
    }

    public Dessert createDessert() {
        return dessertFactory.createDessert("Tiramisu");
    }
}

// American Cafe Factory
class AmericanCafeFactory implements CafeFactory {
    private final CoffeeFactory coffeeFactory = new CoffeeFactory();
    private final DessertFactory dessertFactory = new DessertFactory();

    public Coffee createCoffee() {
        return coffeeFactory.createCoffee("Latte");
    }

    public Dessert createDessert() {
        return dessertFactory.createDessert("Donut");
    }
}
