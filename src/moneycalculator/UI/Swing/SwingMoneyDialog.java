package moneycalculator.UI.Swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.Model.Currency;
import moneycalculator.Model.Money;
import moneycalculator.Model.Number;
import moneycalculator.UI.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private String amount;
    private Currency currency;

    public SwingMoneyDialog() {
        super();//TODO
    }

    @Override
    public void dialog() {
        this.add(createAmount());
        this.add(createCurrencyDialog());
    }

    @Override
    public Money getMoney() {
        return new Money(new Number(Double.parseDouble(amount)), currency);
    }

    private JTextField createAmount() {
        final JTextField text = new JTextField(10);
        text.setText("100");
        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = text.getText();

            }
        });
        return text;
    }

    private JPanel createCurrencyDialog() {
        SwingCurrencyDialog panel = new SwingCurrencyDialog();
        panel.dialog();
        currency = panel.getCurrency();
        return panel;
    }
}
