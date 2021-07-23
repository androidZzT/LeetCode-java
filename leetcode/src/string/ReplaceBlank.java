package string;

public class ReplaceBlank {
    
    public static void main(String[] args) {
        char[] target = new char[] {'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};
        System.out.println(replaceBlank(target));
    }

    private static String replaceBlank(char[] target) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < target.length; i++) { //移动双指针到末尾位置，p1指向原字符末尾，p2指向替换后字符末尾
            if (target[i] == ' ') {
                p1 ++;
                p2 += 3;
            } else if (target[i] != '-') {
                p1 ++;
                p2 ++;
            }
        }
        System.out.println(target.length+ ",p1="+p1 + ",p2="+ p2);
        
        while (p2 != p1) {
            if (target[p1] != ' ') {
                target[p2] = target[p1];
                p2 --;
                p1 --;
            } else {
                p1 --;
                target[p2] = '0';
                p2 --;
                target[p2] = '2';
                p2 --;
                target[p2] = '%';
                p2 --;
            }
            System.out.println(String.valueOf(target));
        }
        return String.valueOf(target);
    }
}