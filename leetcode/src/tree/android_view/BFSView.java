package tree.android_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSView {
    public static void main(String[] args) {
        View[] level1 = new View[] {new ViewGroup("1"), new View("2")};
        View[] level2 = new View[] {new ViewGroup("3"), new View("4"), new View("5")};
        View[] level3 = new View[] {new View("6"), new View("7"), new ViewGroup("8")};
        View level4 = new View("9");
        ViewGroup vg1 = (ViewGroup) level1[0];
        vg1.mChildren = level2;
        ViewGroup vg2 = (ViewGroup) level2[0];
        vg2.mChildren = level3;
        ViewGroup vg3 = (ViewGroup) level3[2];
        vg3.mChildren = new View[]{level4};

        ViewGroup root = new ViewGroup("root");
        root.mChildren = level1;

        System.out.println(BFS(root));
    }

    private static List<View> BFS(View root) {
        if (root == null) return null;

        int level = 0;
        List<View> ans = new ArrayList<>();
        Queue<View> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            View current = queue.poll();
            ans.add(current);
            if (current instanceof ViewGroup) {
                level ++;
                View[] children = ((ViewGroup) current).mChildren;
                for (int i = 0; i < children.length; i++) {
                    queue.add(children[i]);
                }
            }
        }
        System.out.println("level="+ level);
        return ans;
    }
}
