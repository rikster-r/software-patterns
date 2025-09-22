public class Main {
    public static void main(String[] args) {
        Shoe sneakersLeather = new Sneakers(new Leather());
        sneakersLeather.produce();

        Shoe loafersSynthetic = new Loafers(new Synthetic());
        loafersSynthetic.produce();
    }
}