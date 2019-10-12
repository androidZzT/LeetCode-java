package string;

public class CompareVersion {

    public static void main(String[] args) {
        String version1 = "1.0.3.00001.0";
        String version2 = "1.00000.3.0001.00";
        System.out.println(compareVersion(version1, version2));
    }

    private static int compareVersion(String version1, String version2) {
        version1 = removePrefixZero(version1);
        version2 = removePrefixZero(version2);
        System.out.println("input version1 = " + version1);
        System.out.println("input version2 = " + version2);

        int len1 = version1.length();
        int len2 = version2.length();

        if (len1 > len2) {
            version2 = completeStrLength(version2, len1 - len2);
        } else if (len2 > len1) {
            version1 = completeStrLength(version1, len2 - len1);
        }

        for (int i = 0; i < version1.length(); i++) {
            int a = Integer.valueOf(version1.charAt(i));
            int b = Integer.valueOf(version2.charAt(i));
            if (a > b) return 1;
            if (a < b) return -1;
        }
        return 0;
    }

    private static String removePrefixZero(String version) {
        StringBuilder sb = new StringBuilder(version);
        boolean previousDot = false;
        for (int i = 0; i < sb.length(); i++) {
            char cur = sb.charAt(i);
            if (previousDot) {
                int j = i;
                System.out.println("j = " + j);
                while (j < sb.length()) {
                    if (sb.charAt(j) == '0' || sb.charAt(j) == '.') {
                        sb.deleteCharAt(j);
                    } else {
                        break;
                    }
                }
            }
            previousDot = cur == '.';
        }
        if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String completeStrLength(String version, int diffLen) {
        StringBuilder sb = new StringBuilder(version);
        boolean dot = true;
        for (int i = 0; i < diffLen; i++) {
            if (dot) {
                sb.append(".");
            } else {
                sb.append("0");
            }
            dot = !dot;
        }
        return sb.toString();
    }
}
