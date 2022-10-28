package huawei;

import java.util.Scanner;

/**
 * @Classname HJ2 计算某字符出现次数
 * @Description TODO
 * @Date 2022/10/23
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        String s = in.nextLine().toLowerCase();
        char[] arr = s.toCharArray();
        char ss = arr[0];
        System.out.println(getCount(str,ss));
    }

    public static int getCount(String str, char ss) {
        char[] res = str.toCharArray();
        int count = 0;
        for(int i=0;i<res.length;i++){
            if(res[i] == ss){
                count++;
            }
        }
        return count;
    }

}
