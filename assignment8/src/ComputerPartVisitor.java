interface ComputerPartVisitor {
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(CPU cpu);
    void visit(Computer computer);
}

class ComputerPartPriceVisitor implements ComputerPartVisitor {
    private int total = 0;

    public void visit(Mouse mouse) { total += 20; }
    public void visit(Keyboard keyboard) { total += 30; }
    public void visit(Monitor monitor) { total += 100; }
    public void visit(CPU cpu) { total += 200; }
    public void visit(Computer computer) {
        System.out.println("Total Computer Price: $" + total);
    }
}