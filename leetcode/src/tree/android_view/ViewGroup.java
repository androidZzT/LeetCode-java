package tree.android_view;

public class ViewGroup extends View {

    View[] mChildren;

    public ViewGroup() {

    }

    public ViewGroup(View[] children) {
        mChildren = children;
    }
}
