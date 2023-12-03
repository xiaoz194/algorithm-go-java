package class_advanced;


// KMP算法的时间复杂度 O(N)
public class Code03_Kmp {
    public static int getIndexOf(String src, String tar) {
        if (src == null || tar == null || src.length() < 1 || tar.length() < 1 || src.length() < tar.length())
            return -1;
        char[] s = src.toCharArray();
        char[] t = tar.toCharArray();
        int i = 0, j = 0;
        int[] next = getNextArray(t);
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else if (next[j] == -1) { // str2中比对的位置已经无法再往前跳了 即： 已经在第0个位置了
                i++;
            } else {
                j = next[j];
            }
        }
        // i越界或j越界 如果j越界，说明一定匹配成功了
        return j == t.length ? i - j : -1;
    }

    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // next数组的位置
        int cn = 0; // 和i-1位置比较的那个数的位置
        while (i < next.length) {
            if (next[i - 1] == next[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) { // cn还可以往前跳
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
