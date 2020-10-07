package bfs;/*
  @Date:2020/10/7 17:08
  @Author:Administrator
*/

import java.util.*;

public class Interview1619_水域大小 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1},{1,1},{-1,1},{1,-1},{-1,-1}};
    private int rows;
    private int cols;
    public List<Integer> list=new ArrayList<>();
    public int[] pondSizes(int[][] land) {
        rows = land.length;
        if (rows == 0) {
            return new int[]{};
        }
        cols = land[0].length;
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (!marked[i][j]&&land[i][j]==0){ //发现未访问的水域
                    LinkedList<Integer> queue=new LinkedList<>();
                    queue.addLast(i*cols+j);
                    marked[i][j] = true;
                    int size=1; //初始大小
                    while (!queue.isEmpty()){
                        int cur=queue.removeLast();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        for (int k = 0; k <8 ; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if (inArea(newX, newY) && land[newX][newY] == 0 && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY); //新节点入队
                                marked[newX][newY] = true;
                                size++;
                            }
                        }
                    }
                list.add(size);
                }
            }
        }
        int size=list.size();
        int []ans=new int[size];
        int indexi=0;
        for (int i:
             list) {
            ans[indexi++]=i;
        }
        return ans;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
