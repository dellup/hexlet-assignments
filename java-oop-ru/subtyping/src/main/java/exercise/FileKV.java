package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    String filepath;
    Map<String, String> map;

    public FileKV(String filepath, Map<String, String> map) {
        this.filepath = filepath;
        this.map = new HashMap<>(Map.copyOf(map));
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(Map.copyOf(map));
    }
}
// END
