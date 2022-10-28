package huawei;

import java.util.Scanner;

/**
 * @Classname HJ4 字符串分隔
 * @Description TODO
 * @Date 2022/10/23
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        print(str);

    }

    public static void print(String str){
        while(str.length()>8){
            System.out.println(str.substring(0,8));
            str = str.substring(8);
        }
        while(str.length()<8 && str.length()>0){
            str += "0";
        }
        System.out.println(str);

    }
}
