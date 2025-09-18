public class ExternalPaymentProcessor {
    public void makePaymentInCents(int amountInCents) {
        System.out.println("Processing payment of $" + (amountInCents / 100.0) + " using Legacy Payment Gateway.");
    }
}