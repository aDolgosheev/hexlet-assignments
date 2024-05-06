package exercise;

// BEGIN

public class LabelTag implements TagInterface {

    private String tag;

    private TagInterface tagType;

    public LabelTag(String tag, TagInterface tagType) {
        this.tag = tag;
        this.tagType = tagType;
    }

    @Override
    public String render() {
        return "<label>" + tag + tagType.render() + "</label>";
    }
}

// END
