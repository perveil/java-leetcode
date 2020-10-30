package traceBack;/*
  @Date:2020/10/30 12:01
  @Author:Administrator
*/

import java.util.*;

public class leetcode37_解数独 {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9]; //row[i][j] 代表第i行的j，是否已经被使用
        boolean[][] col = new boolean[9][9]; // col[i][j] 代表第i列的j，是否已经被使用
        boolean[][] block = new boolean[9][9]; //block[i][j] 代表第i个3*3宫格内的j，是否已经被使用
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num=board[i][j]-'1';
                    row[i][num] = true;
                    col[j][num] = true;
                    //(i,j) -->第几块block
                    block[i / 3 * 3 + j / 3][num]=true;
                }
            }
        }
        dfs(board,row,col,block,0,0);
    }
    public boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        //逐行从当前位置开始寻找寻空位置
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        // (i,j) 此时的i，j是空的
        for (int num = 0; num <9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            //如果此时行、列、block都可以放
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                board[i][j] = (char) ('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if(dfs(board, row, col, block, i, j)){ //放完之后，查看以后的情况
                    return true;
                }
                else{
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false; // i,j 此时放不进数字，需要回溯到上一步
    }
}

