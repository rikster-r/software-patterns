class ExternalPaymentAdapter implements PaymentProcessor {
    private final ExternalPaymentProcessor externalProcessor = new ExternalPaymentProcessor();

    @Override
    public void makePayment(double amountInDollars) {
        // Adapter logic: convert dollars → cents
        int amountInCents = (int) (amountInDollars * 100);
        externalProcessor.makePaymentInCents(amountInCents);
    }
}