package class08_dp1_force_recursion;

/**
 * @Classname Code01_Hanoi
 * @Description 汉诺塔问题
 * @Date 2022/3/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_Hanoi {
    public void hanoi(int n){
        if(n>0){
            func(n,"左","右","中");
        }
    }

    //1~i 圆盘， 目标是from -> to 中间辅助杆是other
    private void func(int i, String start, String end, String other) {
        if(i==1){
            System.out.println("move 1 from " + start + " to " + end);
        }else{
            func(i-1,start,other,end);
            System.out.println("move + " + i + " from " + start + " to " + end);
            func(i-1,other,end,start);
        }

    }
}
