package class07_greedy_alogrithm;

/**
 * @Classname Code06_maxProfit
 * @Description 例6 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第i天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
 * 示例：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 贪心策略：低价的时候买，才有可能获得最大利润。
 * @Date 2022/3/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code06_maxProfit {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int res = 0;
        for(int i=0;i<prices.length;i++){
            low = Math.min(low,prices[i]);
            res = Math.max(res,prices[i] - low);
        }
        return res;
    }
}
