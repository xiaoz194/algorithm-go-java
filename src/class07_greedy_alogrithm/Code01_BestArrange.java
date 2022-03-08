package class07_greedy_alogrithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname Code01_BestArrange
 * @Description 会议问题
 * 例题1 会议问题。一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体的项目的开始时间和结束时间)，
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。 返回这个最多的宣讲场次。
 * 假设有这几个会议：[7,18],[8,9],[9,10],[15,17]
 * 策略1 按会议开始时间早来安排，不能得到全局最优解
 * 策略2 按项目持续时间短来安排，不能得到全局最优解
 * 策略3 按哪个会议结束时间早先安排谁，然后把这之后不能安排的回忆删掉，再继续找到结束时间早的会议安排，以此得到全局最优解
 * @Date 2022/3/7
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_BestArrange {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    //programs 所有项目，timePoint 当前时刻
    public int bestArrange(Program[] programs,int timePoint){
        Arrays.sort(programs,new ProgramComparator()); //根据结束时间谁早谁在前 排序
        int res = 0;
        //从左往右依次遍历所有会议
        for(int i =0;i<programs.length;i++){
            if(timePoint <= programs[i].start){
                res++;
                timePoint = programs[i].end;
            }
        }
        return res;
    }






}
