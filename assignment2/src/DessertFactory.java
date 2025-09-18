class DessertFactory {
    public Dessert createDessert(String dessertType) {
        if (dessertType.equalsIgnoreCase("Tiramisu")) {
            return new Tiramisu();
        }
        else if (dessertType.equalsIgnoreCase("Donut")) {
            return new Donut();
        }
        else {
            throw new IllegalArgumentException("Invalid dessert type: " + dessertType);
        }
    }
}