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
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] currencyLine = line.split("/");
                    String code = currencyLine[1];
                    String name = currencyLine[0];
                    String sym = currencyLine[2];
                    currency = new Currency(code, name, sym);
                    CurrencySet.getInstance().add(currency);
                }
            }
        } catch (FileNotFoundException fn) {
            System.out.println("File Not Found");
        } catch (IOException io) {
            System.out.println("IOException");
        }
    }
}
