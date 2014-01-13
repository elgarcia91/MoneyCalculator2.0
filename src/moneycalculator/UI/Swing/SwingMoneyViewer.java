package moneycalculator.UI.Swing;

import java.awt.FlowLayout;
import java.awt.PopupMenu;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.Model.Money;
import moneycalculator.UI.MoneyViewer;

public class SwingMoneyViewer extends JPanel implements MoneyViewer {

    private Money money;
    private JLabel label;

    public SwingMoneyViewer() {
        super(new FlowLayout(FlowLayout.CENTER));
        label = new JLabel("-");
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public void showMoney() {
        this.add(createComponents());
    }

    private JLabel createComponents() {
        if (money != null) {
            label.setText(String.valueOf(money));
        }
        return label;
    }
}
