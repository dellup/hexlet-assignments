package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String str;
    List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String str, List<Tag> children) {
        super(name, attributes);
        this.str = str;
        this.children = children;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("<");
        res.append(super.getName());
        for (String key : super.getAttributes().keySet()) {
            res.append(" ");
            res.append(key).append("=\"").append(super.getAttributes().get(key)).append("\"");
        }
        res.append(">");
        res.append(str);
        for (Tag tag : children) {
            res.append(tag.toString());
        }
        res.append("</").append(super.getName()).append(">");
        return res.toString();
    }
}
// END
