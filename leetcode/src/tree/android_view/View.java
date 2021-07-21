package tree.android_view;

public class View {

    protected String name;

    public View(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "View=" + name;
    }
}
