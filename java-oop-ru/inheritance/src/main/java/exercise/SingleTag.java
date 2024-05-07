package exercise;

import java.util.Map;

// BEGIN

public class SingleTag extends Tag {

    public SingleTag(String tag, Map<String, String> map) {
        super(tag, map);
    }

    @Override
    public String toString() {
        return "<" + getTag() + mapToString(getMap()) + ">";
    }
}

// END
