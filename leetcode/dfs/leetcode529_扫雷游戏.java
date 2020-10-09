package dfs;/*
  @Date:2020/10/9 11:34
  @Author:Administrator
*/

import java.util.*;
/*
·如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露，直到遇见地雷或者相邻地雷的空方块
如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回面板。

* */
public class leetcode529_扫雷游戏 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1},{1,1},{-1,1},{1,-1},{-1,-1}};
    private int rows;
    private int cols;
    char[][] board;
    boolean [][]marked;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.board=board;
        rows = board.length;
        if (rows == 0) {
            return new char[][]{};
        }
        cols = board[0].length;
        marked=new boolean[rows][cols]; //访问数组
        if (board[click[0]][click[1]]=='M'){ //挖到地雷，则修改返回
            board[click[0]][click[1]]='X';
            return board;
        }else if (board[click[0]][click[1]]=='E'){ //挖到空白块则需要dfs深搜。直至遇到地雷
            dfs(click[0],click[1]);
            return board;
        } //挖到“B”或者数字直接返回便可
        return board;
    }
    public void dfs(int i, int j) {
        if (!inArea(i,j)||marked[i][j]||board[i][j]=='M') {
            //边界处理、处理已经访问过的、遇到地雷
            return; //结束递归
        }
        //周围有地雷
        int count=count(i,j);
        if (count>0){
            board[i][j]=(char)(count+ '0');
            return;
        }
        marked[i][j]=true; //设置访问标记
        board[i][j]='B';
        dfs( i - 1, j); // 上
        dfs( i + 1, j); // 下
        dfs(i, j - 1); // 左
        dfs( i, j + 1); // 右
        dfs( i - 1, j-1);
        dfs( i -1, j+1);
        dfs(i+1, j-1);
        dfs( i+1, j + 1);

    }
    //返回board[i][j]八个方向上的地雷个数
    public int count(int i, int j) {
        int count=0;
        for (int [] d: directions) {
            int newX=i+d[0];
            int newY=j+d[1];
            if (inArea(newX,newY) && board[newX][newY]=='M'){
                count++;
            }
        }
        return count;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        new leetcode529_扫雷游戏().updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        },new int[]{3,0});
    }
}
