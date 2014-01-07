package moneycalculator.UI.Swing;

import javax.swing.JPanel;
import moneycalculator.Model.Currency;
import moneycalculator.UI.CurrencyDialog;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog{
    private Currency currency;

    @Override
    public void dialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }
    

}
