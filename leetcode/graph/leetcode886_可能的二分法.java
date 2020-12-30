package graph;/*
  @Date:2020/12/30 10:26
  @Author:Administrator
*/

import java.util.*;

public class leetcode886_可能的二分法 {
    //一个完全联通图G  -经过删除边-> 不完全图G1
    //G1如果有两个联通分量,那么直接返回true，大于2直接返回false
    //如果只有一个联通分量，那么返回 该联通分量中的边的数==点的个数-1
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int [][] graph=new int[N][N];
        //删除所有不符合条件的边
        for (int i = 0; i <N; i++) {
            graph[i][i]=-1; //防止节点自旋
        }
        for (int [] dis:dislikes) {
            graph[dis[0]-1][dis[1]-1]=-1;
            graph[dis[1]-1][dis[0]-1]=-1;
        }
        int ans=0;
        //深度优先遍历求的联通分量的个数
        boolean[] seen = new boolean[N];
        for (int i = 0; i < N; ++i) { //遍历所有的节点
            if (!seen[i]) {
                Stack<Integer> stack = new Stack(); //使用栈求最大联通分量的节点个数
                stack.push(i);
                seen[i] = true;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int k = 0; k < N; ++k) {
                        if (graph[node][k] == -1) {
                            continue;
                        } //不能访问的点
                        if (!seen[k]) { //当前k是满足条件的下一个节点
                            stack.push(k);
                            seen[k] = true;
                        }
                    }
                }
                ans++;
            }
        }
        if (ans==2) return true;
        if (ans>2) return  false;
        return ((N*(N-1)/2)-dislikes.length)==N-1;
    }

    public static void main(String[] args) {
        new leetcode886_可能的二分法().possibleBipartition(5,new int[][]{
                {1,2},{2,3},{3,4},{4,5},{1,5}
        });
    }
}
