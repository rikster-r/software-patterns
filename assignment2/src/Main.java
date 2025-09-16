public class Main {
    public static void main(String[] args) {
        // Factory Method Demo
        System.out.println("=== Factory Method Demo ===");
        CoffeeFactory coffeeFactory = new EspressoFactory();
        DessertFactory dessertFactory = new DonutFactory();

        Coffee coffee = coffeeFactory.createCoffee();
        Dessert dessert = dessertFactory.createDessert();

        System.out.println("Ordered (separate factories): " + coffee.getName() + " + " + dessert.getName());

        // Abstract Factory Demo
        System.out.println("\n=== Abstract Factory Demo ===");
        CafeFactory italianCafe = new ItalianCafeFactory();
        CafeFactory americanCafe = new AmericanCafeFactory();

        Coffee italianCoffee = italianCafe.createCoffee();
        Dessert italianDessert = italianCafe.createDessert();

        Coffee americanCoffee = americanCafe.createCoffee();
        Dessert americanDessert = americanCafe.createDessert();

        System.out.println("Italian order (family): " + italianCoffee.getName() + " + " + italianDessert.getName());
        System.out.println("American order (family): " + americanCoffee.getName() + " + " + americanDessert.getName());
    }
}