public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Demo ===");
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        DessertFactory dessertFactory = new DessertFactory();

        Coffee coffee = coffeeFactory.createCoffee("Espresso");
        Dessert dessert = dessertFactory.createDessert("Donut");

        System.out.println("Ordered (separate factories): " + coffee.getName() + " + " + dessert.getName());

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
