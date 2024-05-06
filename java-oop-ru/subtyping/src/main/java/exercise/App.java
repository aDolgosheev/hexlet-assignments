package exercise;

import java.util.Map;
import java.util.Set;

// BEGIN

public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
//        for (Map.Entry<String, String> entry : storage.toMap().entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            storage.unset(key);
//            storage.set(value, key);
//        }

        Map<String, String> data = storage.toMap();
        Set<Map.Entry<String, String>> entries = data.entrySet();
        entries.forEach(entry -> storage.unset(entry.getKey()));
        entries.forEach(entry -> storage.set(entry.getValue(), entry.getKey()));
    }

//    public static void main(String[] args) {
//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
//        App.swapKeyValue(storage);
//        storage.get("key", "default"); // "default"
//        storage.get("value", "default"); // "key"
//
//        System.out.println(storage.toMap());
//    }
}

// END
