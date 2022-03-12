package class08_dp1_force_recursion;

/**
 * @Classname Code06_Knapsack
 * @Description 01背包问题
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。返回你能装下最多的价值是多少?
 * 思路：
 * 暴力递归：从左到右试，第i个包 要 / 不要
 * @Date 2022/3/12
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code06_Knapsack {
    public int maxValue(int[] weights,int[] values,int bag){
        return process(weights,values,0,0,bag);
    }

    //weights[i]和values[i] i号物品的重量和价值 i 位置  alreadyWeight 之前做的决定所形成的当前重量
    // bag 总容量
    //i...的货物自由选择，形成的最大值返回  i之前已经做好了最佳选择得到了一个重量，不用管  重量永远不要超过bag
    //返回值是最大价值
    private int process(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if(alreadyWeight > bag) return 0;
        if(i == weights.length) return 0;
        //要还是不要 取他们俩的最大价值
        return Math.max(
                //不要i位置的物品,形成的价值
                process(weights,values,i+1,alreadyWeight,bag),
                //要i位置的物品，形成的价值
                values[i] +
                process(weights,values,i+1,alreadyWeight+weights[i],bag)
        );
    }
}
