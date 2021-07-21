package tree.android_view;

public class ViewGroup extends View {

    View[] mChildren;

    public ViewGroup(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "ViewGroup=" + name;
    }
}
