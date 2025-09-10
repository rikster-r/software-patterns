public class Main {
    public static void main(String[] args) {
        Car carWithSpoiler = new Car.Builder()
                .engine("V8")
                .transmission("Manual")
                .addSpoiler()
                .build();

        Car paintedCar = new Car.Builder()
                .engine("V6")
                .transmission("Automatic")
                .paint("Blue")
                .build();

        System.out.println(carWithSpoiler);
        System.out.println(paintedCar);
    }
}
