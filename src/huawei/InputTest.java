package huawei;

import java.util.Scanner;

/**
 * @Classname InputTest 输入输出练习
 * @Description TODO
 * @Date 2022/10/25
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a = scanner.hasNext();
        System.out.println(a);
        String b = scanner.next();
        System.out.println(b);
    }
}
