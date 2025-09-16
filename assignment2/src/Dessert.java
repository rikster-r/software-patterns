interface Dessert {
    String getName();
}

class Tiramisu implements Dessert {
    public String getName() { return "Tiramisu"; }
}

class Donut implements Dessert {
    public String getName() { return "Donut"; }
}