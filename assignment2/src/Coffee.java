interface Coffee {
    String getName();
}

class Espresso implements Coffee {
    public String getName() { return "Espresso"; }
}

class Latte implements Coffee {
    public String getName() { return "Latte"; }
}