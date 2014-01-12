package moneycalculator.Command;

import java.util.HashMap;

public class CommandMap {

    private HashMap<String, Command> map = new HashMap<>();

    public CommandMap() {
    }

    public void add(String key, Command command) {
        map.put(key, command);
    }

    public Command get(String key) {
        return map.get(key);
    }
}
