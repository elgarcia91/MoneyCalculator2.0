package moneycalculator.UI.Swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.Model.Currency;
import moneycalculator.UI.CurrencyDialog;
import moneycalculator.Model.CurrencySet;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private Currency currency;

    public SwingCurrencyDialog() {
    }

    @Override
    public void dialog(String label) {
        this.add(new JLabel(label));
        this.add(createCurrencyField());
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    private JComboBox createCurrencyField() {
        final JComboBox comboBox = new JComboBox();
        fillComboBox(comboBox);
        Currency selected = CurrencySet.getInstance().searchCurrency("usd");
        comboBox.setSelectedItem(selected);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() != ItemEvent.SELECTED) {
                    return;
                }
                currency = CurrencySet.getInstance().searchCurrency((String) comboBox.getSelectedItem());
            }
        });
        return comboBox;
    }

    private void fillComboBox(JComboBox comboBox) {
        for (Currency currency : CurrencySet.getInstance()) {
            comboBox.addItem(currency.getCode());
        }
    }
}
