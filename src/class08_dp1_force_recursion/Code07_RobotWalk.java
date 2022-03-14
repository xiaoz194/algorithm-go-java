package class08_dp1_force_recursion;

/**
 * @Classname Code07_RobotWalk
 * @Description 机器人达到指定位置方法数
 * KMP算法扩展题目二
 * 【题目】
 * 假设有排成一行的N个位置，记为 1~N，N一定大于或等于 2。开始时机器人在其中的 M 位置上(M一定是 1~N 中的一个)，
 * 机器人可以往左走或者往右走，如果机器人来到 1 位置， 那么下一步只能往右来到 2 位置;如果机器人来到 N 位置，
 * 那么下一步只能往左来到 N-1 位置。 规定机器人必须走 K 步，最终能来到 P 位置(P 也一定是 1~N 中的一个)
 * 的方法有多少种。给定四个参数 N、M、K、P，返回方法数。
 * 【举例】
 * N=5,M=2,K=3,P=3
 * 上面的参数代表所有位置为 1 2 3 4 5。机器人最开始在 2 位置上，必须经过 3 步，最后到 达 3 位置。
 * 走的方法只有如下 3 种: 1)从2到1，从1到2，从2到3 2)从2到3，从3到2，从2到3 3)从2到3，从3到4，从4到3
 * 所以返回方法数 3。 N=3,M=1,K=3,P=3
 * 上面的参数代表所有位置为 1 2 3。机器人最开始在 1 位置上，必须经过 3 步，最后到达 3 位置。怎么走也不可能，
 * 所以返回方法数 0。
 *
 * 决策方式：往左走或往右走 二叉树
 * @Date 2022/3/14
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code07_RobotWalk {
    //暴力递归版本 时间复杂度 O(2^k)
    public int walkWays1(int N,int M,int K,int P){
        return f1(N,M,K,P);
    }

    //一共是1～n这么多位置  固定值
    //当前在m位置
    //还剩k步需要走
    //最终的目标是p位置 固定值
    //返回有多少种走法
    private int f1(int n, int m, int k, int p) {
        if(k == 0){
            return m == p ? 1 : 0;
        }
        //k>0 说明还有路可以走
        if(m == 1){ //当前在1位置，只能走到2
            return f1(n,2,k-1,p);
        }
        if(m == n){//当前在n位置，只能走到n-1位置
            return f1(n,n-1,k-1,p);
        }
        //机器人来到的是中间位置
        return f1(n,m-1,k-1,p) + f1(n,m+1,k-1,p);
    }

    //==================================================================
    //暴力递归优化 记忆化搜索  时间复杂度 O(k*n) 时间复杂度大大优化
    public int walkWays2(int N,int M,int K,int P){
        //加缓存 建立一张表结构
        int[][] dp = new int[K+1][N+1];
        //将dp所有值都改成-1 表示该状态没被计算
        for(int i=0;i<K+1;i++){
            for(int j=0;j<N+1;j++){
                dp[i][j] = -1;
            }
        }
        //带着缓存表dp，跑递归
        return f2(N,M,K,P,dp);
    }

    private int f2(int n, int m, int k, int p,int[][] dp) {
        if(dp[k][m] != -1){ //说明该状态被算过，不用在递归了，直接返回缓存里的值
            return dp[k][m];
        }
        //缓存没命中 把结果存在缓存中
        if(k == 0){
            dp[k][m] = m==p ? 1 : 0;
            return dp[k][m];
        }
        //k>0 说明还有路可以走
        if(m == 1){ //当前在1位置，只能走到2
            dp[k][m] = f2(n,2,k-1,p,dp);
            return dp[k][m];
        }
        if(m == n){//当前在n位置，只能走到n-1位置
            dp[k][m] = f2(n,n-1,k-1,p,dp);
            return dp[k][m];
        }
        //机器人来到的是中间位置
        dp[k][m] = f2(n,m-1,k-1,p,dp) + f2(n,m+1,k-1,p,dp);
        return dp[k][m];
    }

    //============改动态规划===========================================
    public int dpWay(int n, int m, int k, int p){
        int[][] dp = new int[k+1][n+1];
        dp[0][p] = 1;
        for(int i=0;i<k+1;i++){
            for(int j=0;j<n+1;j++){
                if(k==1){
                    dp[i][j] = dp[i-1][2];
                }else if(k==n){
                    dp[i][j] = dp[i-1][n-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
            }
        }
        return dp[k][m];
    }


}
