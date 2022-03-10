package class07_greedy_alogrithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Code04_IPO
 * @Description 例4 输入:
 *    正数数组capital
 *    正数数组profits
 *    正数k
 *    正数w
 *    含义:capital[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)，
 *    k表示你只能串行的最多做k个项目
 *    w表示你初始的资本
 *    说明: 你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。项目不可以重复做。
 *    输出: 你最后获得的最大钱数。
 *
 * 思路： 根据花费构建一个小根堆，谁的花费小谁在上面 这个小根堆里存的是被锁住的项目
 * 再根据利润值组织一个大根堆 称为解锁的项目 将当前资金可以解锁的项目放进这个大根堆，自然的 利润大的在前面
 * @Date 2022/3/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code04_IPO {
    public static class Node{
        public int p; //利润
        public int c; //花费

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c-o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p-o1.p;
        }
    }

    public static int findMaxCapital(int k,int w,int[] profits,int[] capital){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        //所有项目扔到被锁池中，花费组织的小根堆
        for(int i=0;i<profits.length;i++){
            minCostQ.add(new Node(profits[i],capital[i]));
        }
        for(int i=0;i<k;i++){
            //解锁可以做的项目
            while(!minCostQ.isEmpty() && minCostQ.peek().c<=w){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w+=maxProfitQ.poll().p;
        }
        return w;
    }




}
