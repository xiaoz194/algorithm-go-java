package class07_greedy_alogrithm;

import java.util.PriorityQueue;

/**
 * @Classname Code03_LessMoneySplitGold
 * @Description 例题3 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，
 * 不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板?
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60。
 * 金条要分成10,20,30三个部分。 如果先把长度60的金条分成10和50，花费60; 再把长度50的金条分成20和30，花费50;
 * 一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30，花费60;再把长度30金条分成10和20， 花费30;一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 * 策略思路：构造一个小根堆，然后玩构造哈夫曼树的过程。最终结果的累加和就是最小代价
 * @Date 2022/3/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code03_LessMoneySplitGold {
    public int lessMoney(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            heap.add(arr[i]);
        }
        int cur = 0;
        int sum = 0;
        while(heap.size()>1){
            cur = heap.poll() + heap.poll();
            sum+=cur;
            heap.add(cur);
        }
        return sum;
    }
}
