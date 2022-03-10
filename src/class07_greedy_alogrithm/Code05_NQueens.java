package class07_greedy_alogrithm;

/**
 * @Classname Code05_NQueens
 * @Description 例5 n皇后问题：研究的是如何将n个皇后放置在n×n的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数n，返回有多少种不同的n皇后问题的解决方案。每一种解法包含一个不同的n皇后问题的棋子放置方案。
 * 时间复杂度 O(n!)
 * @Date 2022/3/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code05_NQueens {
    public int nqueens(int n){
        if(n<1){
            return 0;
        }
        //record[0] ? record[1] ? record[2]
        int[] record = new int[n]; //i行的皇后 放在了第几列
        return process(0,record,n);
    }
    // 潜台词：record[0,...i-1]的皇后一定不共行，不共列，不共斜线
    // i 目前来到了第几行
    // record[0,...,i-1]表示之前的行，放的皇后的位置
    // n 代表一共多少行
    // 返回值是摆满所有皇后 合法的摆法有多少种
    public int process(int i,int[] record,int n){
        if(i==n) return 1; // 终止行
        int res = 0;
        for(int j=0;j<n;j++){ //当前行永远在i行，尝试i行所有的列 -> j表示列
            //当前i行的皇后，放在j列，会不会和直前(0,..,i-1)行的皇后共行共列或共斜线
            //如果是，认为无效；如果不是，认为有效
            if(isValid(record,i,j)){
                record[i] = j;
                res += process(i+1,record,n);
            }

        }
        return res;
    }

    //只需要看record[0,..i-1],record[i，...]不需要看
    //返回i行皇后放在j列时的合法性
    private boolean isValid(int[] record, int i, int j) {
        for(int k=0;k<i;k++){//不存在和之前皇后共行的问题，只需要检查是否共列和共斜线
            //Math.abs(record[k]-j) == Math.abs(i-k) 列坐标减完的绝对值等于行坐标减完的绝对值一定共斜线
            //j == record[k] 说明共列
            if(j == record[k] || Math.abs(record[k]-j) == Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

}
