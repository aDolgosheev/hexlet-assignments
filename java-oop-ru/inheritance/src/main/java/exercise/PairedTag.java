package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN

public class PairedTag extends Tag {

    private String bodyTag;

    private List<Tag> tagList;

    public PairedTag(String tag, Map<String, String> map, String bodyTag, List<Tag> tagList) {
        super(tag, map);
        this.bodyTag = bodyTag;
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "<" + getTag() + mapToString(getMap()) + ">" + bodyTag + listToString(tagList) + "</" + getTag() + ">";
    }

    public String listToString(List<Tag> tagList) {
        return tagList.stream()
                .map(e -> "<" + e.getTag() + mapToString(e.getMap()) + ">")
                .collect(Collectors.joining(""));
    }
}

// END
