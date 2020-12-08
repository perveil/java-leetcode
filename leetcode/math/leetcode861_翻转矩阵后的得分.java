package math;/*
  @Date:2020/12/8 10:22
  @Author:Administrator
*/

import java.util.*;

public class leetcode861_翻转矩阵后的得分 {
    public int matrixScore(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        //遍历第一列，保证第一列都是1
        //O(nm)
        int res=0;
        for (int i = 0; i <n ; i++) {
            if (A[i][0]==0){
                for (int j = 0; j <m ; j++) {
                    A[i][j]= A[i][j]==1?0:1;
                }
            }
            res+=1<<(m-1);
        }
        //遍历每一列，保证1最多
        for (int i = 1; i <m ; i++) {
            int countOfOne=0; //每一列1的个数
            for (int j = 0; j <n ; j++) {
                if (A[j][i]==1){
                    countOfOne++;
                }
            }
            if (countOfOne<n-countOfOne){
                countOfOne=n-countOfOne;
            }
            res+=countOfOne*(1<<(m-i-1));
        }
        return res;
    }

    public static void main(String[] args) {
      new leetcode861_翻转矩阵后的得分().matrixScore(new int[][]{
              {0,0,1,1},{1,0,1,0},{1,1,0,0}
      });
    }
}
