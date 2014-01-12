package moneycalculator.Persistence;

import java.util.Date;
import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;

public interface ExchangeRateLoader {

    public ExchangeRate load(Date date, Currency from, Currency to);

    public ExchangeRate load(Currency from, Currency to);
}