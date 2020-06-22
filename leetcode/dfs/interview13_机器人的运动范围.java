package leetcode.dfs;
/*
  @Date:2020/5/4 11:17
  @Author:Administrator
*/

import java.util.*;

public class interview13_机器人的运动范围 {
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int res=0;
    int rows;
    int cols;
    boolean [][] mark;

    public int movingCount(int m, int n, int k) {
        rows=m;
        cols=n;
        mark=new boolean[rows][cols];
        dfs(0,0,k);
        return  res;
    }

    private void dfs(int i, int j, int k1) {
        int sum=indexSum(i)+indexSum(j);
        if (sum>k1) return; //结束递归
        res++;
        mark[i][j]=true;
        for (int k = 0; k <4; k++) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (inArea(newX, newY) && !mark[newX][newY]) {
                dfs(newX, newY, k1);
            }
        }
    }
    private int  indexSum(int i) {
        int sum=0;
        while(i>10){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
