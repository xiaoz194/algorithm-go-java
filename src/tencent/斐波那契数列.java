package question;

/**
 * @Classname 斐波那契数列
 * @Description TODO
 * @Date 2022/8/24
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class 斐波那契数列 {
    //方法一 递归  leetcode会超时
    public int fib(int n){
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }

    //方法二 递归优化 用数组记录已经计算过的值
    int[] arr;
    public int fib2(int n){
        arr = new int[n+1];
        //初始化 没有计算过的全部赋值为-1
        for(int i=0;i<arr.length;i++){
            arr[i] = -1;
        }
        return f(n);
    }

    private int f(int n){
        if(n<=1) return n;
        if(arr[n] != -1){
            return arr[n];
        }
        int sum = f(n-1) + f(n-2);
        arr[n] = sum;
        return sum;
    }

    //方式三 动态规划
    public int fib3(int n){
        // int a = 0,b=1,c=0;
        // for(int i=2;i<=n;i++){
        //     c = (a+b)%1000000007;
        //     a = b;
        //     b = c;
        // }
        //return c;
        if(n<=1) return n;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i =2;i<f.length;i++){
            f[i] = (f[i-1] + f[i-2]) % 1000000007;
        }
        return f[n];
    }

}
