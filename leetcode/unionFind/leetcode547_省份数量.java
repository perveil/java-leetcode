package unionFind;/*
  @Date:2021/1/7 10:20
  @Author:Administrator
*/

import java.util.*;

public class leetcode547_省份数量 {

    private int rows;
    private int cols;
    public int findCircleNum(int[][] isConnected) {
        int res=0;
        rows = isConnected.length;
        if (rows == 0) {
            return 0;
        }
        cols =rows;
        int [] roots=new int[rows]; //根数组
        boolean visited[]=new boolean[rows];
        for (int i = 0; i <rows; i++) { //初始化，以自身为根节点
            roots[i]=i;
            res++;
        }
        //合并岛屿
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if ((isConnected[i][j]==1 && i!=j) &&(!visited[i]||!visited[j])){
                    int p=findRoot(roots,i);
                    int q=findRoot(roots,j);
                    if (p!=q){
                        roots[p]=q;
                        res--;
                    }
                    visited[i]=true;
                    visited[j]=true;
                }
            }
        }
        return res;
    }
    int findRoot(int []roots,int id){
        return (id==roots[id])?id:findRoot(roots,roots[id]);
    }

    public static void main(String[] args) {
        new leetcode547_省份数量().findCircleNum(new int[][]{
                {1,1,1},{1,1,0},{1,0,1}
        });
    }
}
