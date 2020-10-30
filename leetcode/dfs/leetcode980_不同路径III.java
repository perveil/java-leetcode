package dfs;/*
  @Date:2020/10/30 12:43
  @Author:Administrator
*/

import java.util.*;
//每一个无障碍（0/1）方格都要通过一次，但是一条路径中不能重复通过同一个方格（访问过的不能再访问）
public class leetcode980_不同路径III {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    int[][] grid;
    int res=0;
    public int uniquePathsIII(int[][] grid) {
        this.grid=grid;
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        int startX = 0,startY = 0,stepNum = 1; //stepNum从1开始，算一步
        for(int i=0; i<rows; ++i)
            for(int j=0; j<cols; ++j){
                if(grid[i][j]==1) {  //发现入口
                    startX=i;
                    startY=j;
                }
                if (grid[i][j] == 0){
                    stepNum ++;
                }
            }
        dfs(startX,startY,stepNum);
        return res;
    }
    public void dfs(int i, int j,int stepNum) {
        if (!inArea(i,j)||grid[i][j]==-1) {
            //边界处理、处理已经访问过的、遇到障碍
            return; //结束递归
        }
        if (grid[i][j]==2){ //到达了终点
           if (stepNum==0){
               res++;
           }
            return;
        }
        grid[i][j]=-1;
        for (int [] d :directions){
            int newX=i+d[0];
            int newY=j+d[1];
            dfs(newX,newY,stepNum-1);
        }
        grid[i][j] = 0; //回溯
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
