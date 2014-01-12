package moneycalculator.Persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;

public class FileCurrencySetLoader implements CurrencySetLoader {

    private final String file;

    public FileCurrencySetLoader(String file) {
        this.file = file;
    }

    @Override
    public void load() {
        try {
            Currency currency;
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            while (true) {
                String line = reader.readLine().trim();
                if (line == null) {
                    break;
                } else {
                    String[] currencyLine = line.split(",");
                    currency = new Currency(currencyLine[1], currencyLine[0], currencyLine[2]);
                    CurrencySet.getInstance().add(currency);
                }
            }
        } catch (FileNotFoundException fn) {
        } catch (IOException io) {
        }
    }
}
