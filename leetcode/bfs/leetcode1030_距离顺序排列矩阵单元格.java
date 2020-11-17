package bfs;
/*
  @Date:2020/11/17 8:59
  @Author:Administrator
*/

import java.util.*;

public class leetcode1030_距离顺序排列矩阵单元格 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][]res=new int[R*C][2];
        rows = R;
        cols = C;
        //初始化
        res[0][0]=r0;
        res[0][1]=c0;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(r0*cols+c0);
        boolean marked[]=new boolean[R*C];
        marked[r0*cols+c0]=true;
        int i=1;
        while(!queue.isEmpty()){
            int code=queue.remove();
            int r = code / cols, c = code % cols;
            for (int k = 0; k <4 ; k++) {
                int newX = r + directions[k][0];
                int newY = c + directions[k][1];
                if (inArea(newX, newY) && !marked[newX*cols+newY]) {
                    res[i][0]=newX;
                    res[i][1]=newY;
                    i++;
                    queue.add(newX*cols+newY);
                    marked[newX*cols+newY]=true;//访问
                }
            }
        }
        return res;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        new leetcode1030_距离顺序排列矩阵单元格().allCellsDistOrder(2,2,0,1);
    }
}
