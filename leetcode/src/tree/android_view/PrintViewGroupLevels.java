package tree.android_view;

public class PrintViewGroupLevels {

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

        System.out.println(printViewLevels(root));
    }

    private static int printViewLevels(View root) {
        if (root == null) return 0;
        return getDeep(root, 1);
    }

    private static int getDeep(View root, int deep) {
        if (root instanceof ViewGroup) {
            for (View child : ((ViewGroup) root).mChildren) {
                return getDeep(child, deep + 1);
            }
        }
        return deep;
    }
}
