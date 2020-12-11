package graph.bfs;
/*
  @Date:2020/12/1 10:47
  @Author:Administrator
*/

import java.util.*;

public class leetcode733_图像渲染 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return null;
        rows=image.length;
        cols=image[0].length;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(sr*cols+sc);
        int startColor=image[sr][sc];
        if(startColor==newColor) return image;
        image[sc][sr]=newColor;
        while (!queue.isEmpty()){
            int cur=queue.poll(); //出队
            int curX = cur / cols;
            int curY = cur % cols;
            for (int j = 0; j <4 ; j++) {
                int newX = curX + directions[j][0];
                int newY = curY + directions[j][1];
                if (inArea(newX,newY)&&image[newX][newY]==startColor){
                    image[newX][newY]=newColor;
                    queue.add(newX*cols+newY);
                }
            }
        }
        return image;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
