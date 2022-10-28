package huawei;

import java.util.Scanner;

/**
 * @Classname HJ6 质数因子
 * @Description TODO
 * @Date 2022/10/23
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long q = (long)Math.sqrt(n);
        for(int i = 2; i <= q; i++){
            while(n%i == 0){
                n/=i;
                System.out.print(i+" ");
            }
        }
        if(n!=1){
            System.out.print(n);
        }
    }
}
