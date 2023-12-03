package class_advanced;

// 马拉车算法 解决字符串中最长回文子串的问题
// 四个概念：
// 1) 回文直径 回文半径
// 2) 生成回文半径数组
// 3)R  之前扩的所有位置中所到达的最右回文右边界  C 取得更远边界时中心点在哪
//
// 玩法：
// 1）当前i位置不在R范围内 i>=R 包括压线的情况，直接暴力扩
// 2）当前i位置在R范围内 优化 三种情况
// 时间复杂度O(N)
public class Code04_Manacher {
    public static void main(String[] args) {
        String tar = "aba";
        int res = longestPalindrome(tar);
        System.out.println(res);
    }

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2 + 1];
        int index = 0;
        for (int i=0;i<res.length;i++) {
            res[i] = (i&1) == 0 ? '#':charArr[index++]; // i&1 == 0 => i%2 == 0 在偶数位置补# 0 ，2，4...补#
        }
        return res;
    }

    public static int longestPalindrome(String tar) {
        if(tar==null || tar.length()==0) {
            return 0;
        }
        char[] str = manacherString(tar); // 1234 -> #1#2#3#4
        int[] pArr = new int[str.length]; // 回文半径数组
        int C = -1; //中心点位置
        int R = -1;// 回文右边界最右位置再往右一个
        int max = Integer.MIN_VALUE;
        for(int i=0;i<str.length;i++) { // 每一个位置都求出回文半径
            // i至少的回文区域 先给pArr
            pArr[i] = R >i ? Math.min(pArr[2*C -i],R-i) : 1; // 2*C - i 就是i'的回文半径

            while(i + pArr[i] < str.length && i - pArr[i] > -1){
                if(str[i+pArr[i]]==str[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i]>R){ // 判断当前i位置的回文半径有没有超过R，超过则更新R和C 否则不更新
                R = i+pArr[i];
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max - 1; // 处理串的最大回文半径 -1 = 原始串的回文长度
    }


}
