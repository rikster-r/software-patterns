interface DessertFactory {
    Dessert createDessert();
}

class TiramisuFactory implements DessertFactory {
    public Dessert createDessert() { return new Tiramisu(); }
}

class DonutFactory implements DessertFactory {
    public Dessert createDessert() { return new Donut(); }
}