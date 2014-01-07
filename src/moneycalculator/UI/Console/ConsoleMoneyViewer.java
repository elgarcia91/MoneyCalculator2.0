package moneycalculator.UI.Console;

import moneycalculator.Model.Money;
import moneycalculator.UI.MoneyViewer;

public class ConsoleMoneyViewer implements MoneyViewer{
    private Money money;

    @Override
    public void showMoney() {
        System.out.println(money);
    }

    public ConsoleMoneyViewer(Money money) {
        this.money = money;
    }
      
}
