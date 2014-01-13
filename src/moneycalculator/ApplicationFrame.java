package moneycalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.Command.ActionListenerFactory;
import moneycalculator.UI.CurrencyDialog;
import moneycalculator.UI.MoneyDialog;
import moneycalculator.UI.MoneyViewer;
import moneycalculator.UI.Swing.SwingCurrencyDialog;
import moneycalculator.UI.Swing.SwingMoneyDialog;
import moneycalculator.UI.Swing.SwingMoneyViewer;

public class ApplicationFrame extends JFrame {

    private ActionListenerFactory factory;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;

    ApplicationFrame(ActionListenerFactory factory) {
        super("Money Calculator");
        this.factory = factory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750, 200);
        this.setLocationRelativeTo(null);
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createMainPanel(), BorderLayout.NORTH);
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("Convert: "));
        panel.add(createSwingMoneyDialog());
        panel.add(new JLabel("To: "));
        panel.add(createSwingCurrencyDialog());
        this.add(createSwingMoneyViewer());
        return panel;
    }

    private JPanel createSwingMoneyViewer() {
        SwingMoneyViewer panel = new SwingMoneyViewer();
        panel.add(createLabel());
        moneyViewer = panel;
        panel.showMoney();
        return panel;
    }

    private JLabel createLabel() {
        JLabel label = new JLabel();
        label.setText("Result: ");
        return label;
    }
    private JPanel createSwingMoneyDialog() {
        SwingMoneyDialog panel = new SwingMoneyDialog();
        panel.dialog();
        moneyDialog = panel;
        return panel;
    }

    private JPanel createSwingCurrencyDialog() {
        SwingCurrencyDialog panel = new SwingCurrencyDialog();
        panel.dialog("");
        currencyDialog = panel;
        return panel;
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;

    }

    private JButton createCalculateButton() {
        JButton calculate = new JButton("CALCULATE");
        calculate.addActionListener(factory.addAction("calc"));
        return calculate;
    }

    private JButton createExitButton() {
        JButton exit = new JButton("EXIT");
        exit.addActionListener(factory.addAction("exit"));
        return exit;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyViewer getMoneyViewer() {
        return moneyViewer;
    }

}
