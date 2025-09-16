interface CoffeeFactory {
    Coffee createCoffee();
}

class EspressoFactory implements CoffeeFactory {
    public Coffee createCoffee() { return new Espresso(); }
}

class LatteFactory implements CoffeeFactory {
    public Coffee createCoffee() { return new Latte(); }
}