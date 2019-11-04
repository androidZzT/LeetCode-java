package tree.android_view;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSViews {

    public static void main(String[] args) {
        View[] level1 = new View[] {new ViewGroup(), new View()};
        View[] level2 = new View[] {new ViewGroup(), new View(), new View()};
        View[] level3 = new View[] {new View(), new View(), new ViewGroup()};
        View level4 = new View();
        ViewGroup vg1 = (ViewGroup) level1[0];
        vg1.mChildren = level2;
        ViewGroup vg2 = (ViewGroup) level2[0];
        vg2.mChildren = level3;
        ViewGroup vg3 = (ViewGroup) level3[2];
        vg3.mChildren = new View[]{level4};

        ViewGroup root = new ViewGroup();
        root.mChildren = level1;
    }

    private static List<View> DFS(View root) {
        List<View> ans = new ArrayList<>();
        if (root != null && root instanceof ViewGroup) {
            Stack<View> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                View[] children = ((ViewGroup) root).mChildren;
                for (int i=0; i<children.length; i++) {
                    View child = children[i];
                    if (child instanceof ViewGroup) {
                        stack.push(child);
                    } else {

                    }
                }
            }
        }
        return ans;
    }
}
