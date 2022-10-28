package huawei;

import java.util.Scanner;

/**
 * @Classname HJ5 进制转换
 * @Description TODO
 * @Date 2022/10/23
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = Integer.parseInt(s.substring(2,s.length()),16);
        System.out.println(res);
    }
}
