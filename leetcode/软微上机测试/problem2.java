package 软微上机测试;
/*
  @Date:2020/9/19 14:17
  @Author:Administrator
*/

import java.util.*;

public class problem2 {
    private static final int[][] directions = {
            {-1, 0},{0, -1},
            {1, 0}, {0, 1},
            {-1,-1},{-1,1},
            {1,1},{1,-1}
    }; //方向数组
    public static void main(String[] args) {
        new problem2().solution();
    }
    public  void solution() {
        Scanner reader = new Scanner(System.in) ;
        while(reader.hasNext())
        {
            int m = reader.nextInt() ;
            int n= reader.nextInt();
            char [][] chars = new char[m][n] ;
            String [] strs=new String[m];
            for(int index=0;index<m;index++)
            {
                strs[index] = reader.nextLine();
                chars[index]=strs[index].toCharArray();
            }
            boolean[][] marked=new boolean[m][n]; //初始化标记数组
            int res=0;
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    if (marked[i][j]==false&&chars[i][j]=='#'){
                        res++;
                        bfs(marked,i,j,chars,m,n);
                    }
                }
            }
            System.out.println(res);
        }
    }
    //广度优先遍历
    public  void bfs(boolean[][]marked,int i, int j,char[][] chars,int m,int n) {
        marked[i][j]=true;
        for (int k = 0; k <8; k++) {
            int newX=i+directions[k][0];
            int newY=j+directions[k][1];
            if(inArea(newX,newY,m,n)&&chars[newX][newY]=='#'
                    &&marked[newX][newY]==false){
                bfs(marked,newX,newY,chars,m,n);
            }
        }

    }
    private boolean inArea(int x, int y,int m,int n) {
        // 等于号不要忘了
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
