package class_advanced;


public class Code05_GetMaxLcpStr {

    public static void main(String[] args) {
        String s = "a";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
    private static char[] manacherStr(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2 + 1];
        int index = 0;
        for(int i=0;i<res.length;i++){
            res[i] = (i&1) == 0 ? '#':charArr[index++];
        }
        return res;
    }

    public static String longestPalindrome(String s) {
        if (s==null || s.length() < 1) {
            return s;
        }
        char[] str = manacherStr(s);
        int[] help = new int[str.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        int start = -1;
        for(int i=0;i<str.length;i++) {
            help[i] = R > i ? Math.min(help[2*C-i],R-i) : 1;
            while(i+help[i]<str.length && i-help[i]>-1) {
                if(str[i+help[i]] == str[i-help[i]]){
                    help[i]++;
                }else{
                    break;
                }
            }
            if(i+help[i]>R){
                R = i+help[i];
                C = i;
            }
            if (max<help[i]){
                max = help[i];
                start = i-help[i]+1;
            }

        }
        StringBuffer sb = new StringBuffer();
        for(int k=start;k<=start+(max-1)*2;k++){
            sb.append(str[k]);
        }
        return sb.toString().replace("#","");
    }
}
