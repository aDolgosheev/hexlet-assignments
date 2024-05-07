package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN

public class Tag {

    private String tag;

    private Map<String, String> map;

    public Tag(String tag, Map<String, String> map) {
        this.tag = tag;
        this.map = map;
    }

    public String toString() {
        return "";
    }

    public String mapToString(Map<String, String> map) {
        String str = " " + map.entrySet()
                .stream()
                .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
                .collect(Collectors.joining(" "));
        return map.isEmpty()? "" : str;
    }

    public String getTag() {
        return tag;
    }

    public Map<String, String> getMap() {
        return map;
    }
}

// END
