package huawei;

import java.util.Scanner;

/**
 * @Classname HJ7 取近似值
 * @Description TODO
 * @Date 2022/10/23
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float a = in.nextFloat();
        int b = (int)a;
        float ans = a-b;
        if(ans>=0.5 && ans<1){
            System.out.println(b+1);
        }else{
            System.out.println(b);
        }
    }
}
