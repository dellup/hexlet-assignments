package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage map) {
        for (String key: map.toMap().keySet()) {
            String value = map.get(key, "default");
            map.set(value, key);
            map.unset(key);
        }
    }
}
// END
