package class08_dp1_force_recursion;

/**
 * @Classname Code02_PringAllSubsquence
 * @Description 打印一个字符串所有的子序列
 * 经典的尝试方法，一个字符要还是不要，做决策
 * @Date 2022/3/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code02_PrintAllSubsquence {
    public void printAllSubsquence(String str){
        char[] chs = str.toCharArray();
        process(chs,0);
    }
    //当前来到i位置，要和不要，走两条路
    //之前的选择，所形成的结果，通过str复用得到 优化 节省空间
    private void process(char[] str, int i) {
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str,i+1); //要当前字符的路
        char tmp = str[i];
        str[i] = 0;
        process(str,i+1); //不要当前字符的路
        str[i] = tmp;
    }
}
