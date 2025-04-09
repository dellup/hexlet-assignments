package exercise;

// BEGIN
public class LabelTag extends TagDecorator {
    private String value;

    public LabelTag(String value, TagInterface tag) {
        super(tag);
        this.value = value;
    }

    @Override
    public String render() {
        return "<label>"
                + value
                + super.render()
                + "</label>";
    }
}
// END
