package class08_dp1_force_recursion;

import java.util.ArrayList;

/**
 * @Classname Code03_printAllPermutations
 * @Description 求一个字符串的全排列
 * @Date 2022/3/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code03_printAllPermutations {
    public ArrayList<String> printAllPermutations(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str==null || str.length()==0) return res;
        char[] chs = str.toCharArray();
        process(chs,0,res);
        return res;
    }

    //str[i...]范围上，所有的字符都可以在i位置上，后续都去尝试
    //str[0,...,i-1]范围上，是之前做的选择
    //把所有的全排列形成的字符串加入到res里去
    private void process(char[] str, int i, ArrayList<String> res) {
        if(i == str.length) res.add(String.valueOf(str));
        boolean[] visit = new boolean[26];
        for(int j=i;j<str.length;j++){
            if(!visit[str[j] - 'a']){
                visit[str[j] - 'a'] = true;
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);
            }
        }
    }

    private void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}
