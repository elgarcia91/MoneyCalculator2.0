package moneycalculator.UI.Console;

import moneycalculator.Model.Currency;
import moneycalculator.UI.CurrencyViewer;

public class ConsoleCurrencyViewer implements CurrencyViewer{
    private Currency currency;

    @Override
    public void showCurrency() {
        System.out.println(currency);
    }

    public ConsoleCurrencyViewer(Currency currency) {
        this.currency = currency;
    }
    
    
}
