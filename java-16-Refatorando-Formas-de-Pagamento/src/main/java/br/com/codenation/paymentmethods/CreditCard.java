package br.com.codenation.paymentmethods;

public class CreditCard implements PriceStrategy {

    private final double CREDIT_TAX = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * CREDIT_TAX;
    }
}
