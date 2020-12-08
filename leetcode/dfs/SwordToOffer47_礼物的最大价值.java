package dfs;/*
  @Date:2020/12/8 16:18
  @Author:Administrator
*/

import java.util.*;

public class SwordToOffer47_礼物的最大价值 {
    int directions[][]={{1,0},{0,1}};
    int res=-1;
    int rows;
    int cols;
    public int maxValue(int[][] grid) {
        rows=grid.length;
        cols=grid[0].length;
        dfs(grid,0,0,grid[0][0]);
        return  res;
    }
    public void dfs(int[][] grid,int curx,int cury,int curValue) {
        if (!inArea(curx,cury)){  //如果不在区域内直接返回
            return;
        }
        if (curx==rows-1 && cury==cols-1){
            res=Math.max(curValue,res);
            return ;
        }
        for (int i = 0; i <2 ; i++) {
            int newX=curx+directions[i][0];
            int newY=cury+directions[i][1];
            if (inArea(newX,newY)){
                dfs(grid,newX,newY,curValue+grid[newX][newY]);
            }
        }
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
