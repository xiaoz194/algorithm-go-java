package huawei;

import java.util.Scanner;

/**
 * @Classname  HJ1 字符串最后一个单词的长度
 * @Description TODO
 * @Date 2022/10/23
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = len(s);
        System.out.print(res);
    }

    public static int len(String s){
        String[] ans = s.split(" ");
        String str = ans[ans.length-1];
        char[] res = str.toCharArray();
        int count = 0;
        for(int i=0;i<res.length;i++){
            count++;
        }
        return count;
    }
}
