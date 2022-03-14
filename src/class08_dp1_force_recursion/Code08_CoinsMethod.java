package class08_dp1_force_recursion;

/**
 * @Classname Code08_CoinsMethod
 * @Description
 * 【题目】
 * 给定数组 arr，arr 中所有的值都为正数。每个值代表一枚该面值的硬币。
 * 再给定一个整数 aim，代表要找的钱数，求有多少种得到aim的方法。
 * 策略：从0开始遍历数组，每一枚 要 / 不要
 * @Date 2022/3/14
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code08_CoinsMethod {
    public int coinsMin(int[] arr,int aim){
        return f(arr,0,0,aim);
    }
    //arr 硬币都在其中， 固定参数
    //aim 最终要达成的目标，固定参数
    //如果自由选择arr[index...]这些硬币， 但是之前的硬币已经让你拥有了pre这么多钱。
    //返回 最后得到aim的方法数
    public int f(int[] arr,int index,int pre,int aim){
        if(index == arr.length) return pre==aim? 1 : 0;
        return f(arr,index+1,pre,aim) + f(arr,index+1,pre+arr[index],aim);
    }
}
