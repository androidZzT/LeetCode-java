package tree.android_view;

import java.util.*;

public class                                                                                                                                                                                                                                                                                          DFSViews {

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

        List<View> dfsAns = DFS(root);
        System.out.println(dfsAns);
    }

    private static List<View> DFS(View root) {
        List<View> ans = new ArrayList<>();
        if (root != null && root instanceof ViewGroup) {
            Stack<View> stack = new Stack<>();
            Map<View, Boolean> visitedMap = new HashMap<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                View top = stack.peek();
                boolean visited = visitedMap.get(top) == null? false : visitedMap.get(top);
                if (!visited) {
                    visitedMap.put(top, true);
                    if (top instanceof ViewGroup) {
                        View[] children = ((ViewGroup) top).mChildren;
                        System.out.println("children=" + Arrays.toString(children));
                        for (int i = children.length - 1; i >= 0; i--) {
                            stack.push(children[i]);
                        }
                    }
                } else {
                    ans.add(stack.pop());
                }
            
            }
        }
        return ans;
    }
}
