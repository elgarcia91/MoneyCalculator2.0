package moneycalculator.Model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    private static CurrencySet instance;

    private CurrencySet() {
        super();
    }

    public static CurrencySet getInstance() {
        if (instance == null) {
            instance = new CurrencySet();
        }
        return instance;
    }

    public Currency searchCurrency(String token) {
        for (Currency currency : CurrencySet.getInstance()) {
            if (currency.getCode().equalsIgnoreCase(token)) {
                return currency;
            } else if (currency.getSymbol().equalsIgnoreCase(token)) {
                return currency;
            } else if (currency.getName().equalsIgnoreCase(token)) {
                return currency;
            }
        }
        return null;
    }
}