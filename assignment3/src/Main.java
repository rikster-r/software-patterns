public class Main {
    public static void main(String[] args) {
        ExternalPaymentAdapter paymentProcessor = new ExternalPaymentAdapter();

        paymentProcessor.makePayment(30.50);
    }
}