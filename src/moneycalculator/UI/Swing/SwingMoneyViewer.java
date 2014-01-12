package moneycalculator.UI.Swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.Model.Money;
import moneycalculator.UI.MoneyViewer;

public class SwingMoneyViewer extends JPanel implements MoneyViewer {

    private Money money;
    private JLabel label;

    public SwingMoneyViewer() {
        label = new JLabel(" ");
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public void showMoney() {
        label.setText(String.valueOf(money));
    }
}
