package graph.dfs;/*
  @Date:2020/12/3 11:27
  @Author:Administrator
*/

import java.util.*;

public class leetcode947_移除最多的同行或同列石头 {
    public int removeStones(int[][] stones) {
        int N = stones.length; //stone 数
        // graph[i][0] = the length of the 'list' graph[i][1:]
        int[][] graph = new int[N][N];
        //graph[i][1...N-1] 是和第i个stone 同行或者同列的石头编号
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) { //i和j在 同一行和同一列
                    graph[i][++graph[i][0]] = j;
                    graph[j][++graph[j][0]] = i;
                }
            }
        }
        int ans=0;
        //深度优先遍历求的联通分量，每个联通分量只剩下一个
        boolean[] seen = new boolean[N];
        for (int i = 0; i < N; ++i){ //遍历所有的联通分量
            if (!seen[i]) {
                int cur=0;
                Stack<Integer> stack = new Stack(); //使用栈求最大联通分量的节点个数
                stack.push(i);
                seen[i] = true;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    cur++;
                    for (int k = 1; k <= graph[node][0]; ++k) {
                        int nei = graph[node][k]; // nei 是和i边直接相连的节点
                        if (!seen[nei]) {
                            stack.push(nei);
                            seen[nei] = true;
                        }
                    }
                }
                ans+=cur-1;
            }
        }
        return  ans;
    }
}
