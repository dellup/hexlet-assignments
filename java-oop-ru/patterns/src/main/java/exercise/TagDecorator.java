package exercise;

abstract class TagDecorator implements TagInterface {
    protected TagInterface component;

    public TagDecorator(TagInterface c) {
        component = c;
    }

    @Override
    public String render() {
        return component.render();
    }
}
