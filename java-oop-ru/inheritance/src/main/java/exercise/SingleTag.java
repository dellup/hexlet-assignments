package exercise;
import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
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
        return res.toString();
    }
}
 // END
