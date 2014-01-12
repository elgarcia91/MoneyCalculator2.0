package moneycalculator.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerFactory {

    CommandMap map;

    public ActionListenerFactory(CommandMap map) {
        this.map = map;
    }

    public ActionListener addAction(final String key) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Command command = map.get(key);
                if (command == null) {
                    return;
                }
                command.execute();
            }
        };
    }
}
