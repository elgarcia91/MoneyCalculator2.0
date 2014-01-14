package moneycalculator.Persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import moneycalculator.Model.Currency;
import moneycalculator.Model.Number;
import moneycalculator.Model.ExchangeRate;

public class FileExchangeRateLoader implements ExchangeRateLoader {

    private final String file;

    public FileExchangeRateLoader(String fileRates) {
        this.file = fileRates;
    }

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            if (from.getCode().equals(to.getCode())) {
                return new ExchangeRate(new Date(), from, to, new Number(1));
            }
            if (to.getCode().equals("EUR")) {
                return new ExchangeRate(new Date(), from, to, calculateInverse(from, to));
            }
            if (!"EUR".equals(from.getCode())) {
                return new ExchangeRate(new Date(), from, to, calculateRate(from, to));
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = reader.readLine().trim();
                if (line == null) {
                    break;
                } else {
                    String[] rateLine = line.split("/");
                    if (rateLine[1].equalsIgnoreCase(to.getCode())) {
                        return new ExchangeRate(new Date(), from, to, new Number(Double.valueOf(rateLine[0])));
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            return new ExchangeRate(new Date(), from, to, new Number(15));
        } catch (IOException ex) {
            return new ExchangeRate(new Date(), from, to, new Number(30));
        }
        return null;
    }

    private Number calculateRate(Currency from, Currency to) {
        Currency euro = new Currency("EUR", "EURO", "€");
        Number rateFrom = load(euro, from).getRate();
        Number rateTo = load(euro, to).getRate();
        return new Number(rateTo.divide(rateFrom));
    }

    private Number calculateInverse(Currency from, Currency to) {
        Number one = new Number(1);
        Number rateInverse = one.divide(load(to, from).getRate());
        return rateInverse;
    }
}