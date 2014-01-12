package moneycalculator.Persistence;

import java.util.Date;
import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;

public class FileExchangeRateLoader implements ExchangeRateLoader {

    public FileExchangeRateLoader(String fileRates) {
    }

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
