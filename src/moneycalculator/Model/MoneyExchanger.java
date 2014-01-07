package moneycalculator.Model;

public class MoneyExchanger {

    public Money exchange(Number number, ExchangeRate rate) {
        return new Money(number.multiply(rate.getRate()), rate.getTo());
    }
}