package dp;/*
  @Date:2020/12/8 16:30
  @Author:Administrator
*/

import java.util.*;

public class swordToOffer47_礼物的最大价值 {
    int rows;
    int cols;
    public int maxValue(int[][] grid) {
        rows=grid.length;
        cols=grid[0].length;
        for (int i = 1; i <cols; i++) {
            grid[0][i]=grid[0][i-1]+grid[0][i];
        }
        for (int i = 1; i <rows; i++) {
            grid[i][0]=grid[i-1][0]+grid[i][0];
        }
        for (int i = 1; i <rows ; i++) {
            for (int j = 1; j <cols ; j++) {
                grid[i][j]=Math.max(grid[i-1][j]+grid[i][j],grid[i][j-1]+grid[i][j]);
            }

        }
        return grid[rows-1][cols-1];
    }
}
