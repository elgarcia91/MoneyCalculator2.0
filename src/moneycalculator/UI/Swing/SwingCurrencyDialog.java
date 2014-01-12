package moneycalculator.UI.Swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import moneycalculator.Model.Currency;
import moneycalculator.UI.CurrencyDialog;
import javax.swing.JTextField;
import moneycalculator.Model.CurrencySet;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private Currency currency;

    public SwingCurrencyDialog() {
    }

    @Override
    public void dialog() {
        this.add(createCurrencyField());
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    private JTextField createCurrencyField() {
        final JTextField text = new JTextField(10);
        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                currency = CurrencySet.getInstance().searchCurrency(text.getText());
            }
        });
        return text;
    }
}
