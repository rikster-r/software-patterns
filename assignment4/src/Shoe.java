abstract class Shoe {
    protected Material material;

    public Shoe(Material material) {
        this.material = material;
    }

    public abstract void produce();
}

class Sneakers extends Shoe {
    public Sneakers(Material material) {
        super(material);
    }

    @Override
    public void produce() {
        System.out.println("Producing Sneakers with " + material.getMaterial());
    }
}

class Loafers extends Shoe {
    public Loafers(Material material) {
        super(material);
    }

    @Override
    public void produce() {
        System.out.println("Producing Loafers with " + material.getMaterial());
    }
}