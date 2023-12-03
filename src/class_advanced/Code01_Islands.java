package class_advanced;

/**
 * 岛问题
 * 【题目】 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
 * 【举例】
 * 001010
 * 111010
 * 100100
 * 000000
 * 这个矩阵中有三个岛
 *
 * 时间复杂度 O(M*N)
 */
public class Code01_Islands {
    public int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int M = m.length; // 行
        int N = m[0].length; //列
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, M, N);
                }
            }
        }
        return res;
    }

    private void infect(int[][] m, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || m[i][j] != 1)
            return;
        m[i][j] = 2;
        infect(m,i+1,j,M,N);
        infect(m,i-1,j,M,N);
        infect(m,i,j+1,M,N);
        infect(m,i,j-1,M,N);
    }

}
