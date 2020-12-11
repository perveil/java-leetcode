package graph.dfs;/*
  @Date:2020/12/9 19:23
  @Author:Administrator
*/

import java.util.*;
/*
*  超出内存限制
*
* */
public class leetcode1319_连通网络的操作次数 {
    //联通分量
    //一个无向图为联通分量只需要n-1条边，n指的是节点个数
    public int makeConnected(int n, int[][] connections) {
        int N = connections.length; //边数
        if(n-1>N){ //边数小于节点数-1时,返回-1
            return -1;
        }
        //n-1>=connections.length
        //统计联通分量个数，假设有m个联通分量，连接m个联通分量需要m-1条边，则需要m-1次拔插
        int[][] graph = new int[n][n]; //邻接矩阵，容易导致内存溢出
        //graph[i][1...N-1] 是和第i个stone 同行或者同列的石头编号
        //graph[i][0] 和第i个计算机连接的计算机个数
        for (int i = 0; i < N; ++i) {
            int vertexStart=connections[i][0];
            int vertexEnd=connections[i][1];
            graph[vertexStart][++graph[vertexStart][0]]=connections[i][1];
            graph[vertexEnd][++graph[vertexEnd][0]] = connections[i][0];
        }

        int ans=0;
        //深度优先遍历求的联通分量的个数
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; ++i){ //遍历所有的节点
            if (!seen[i]) {
                Stack<Integer> stack = new Stack(); //使用栈求最大联通分量的节点个数
                stack.push(i);
                seen[i] = true;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int k = 1; k <= graph[node][0]; ++k) {
                        int nei = graph[node][k]; // nei 是和i边直接相连的节点
                        if (!seen[nei]) {
                            stack.push(nei);
                            seen[nei] = true;
                        }
                    }
                }
                ans++;
            }
        }
        return  ans-1;
    }


    //内存优化，使用ArrayList动态添加元素
    private List<Integer>[] graph;
    private boolean[] visited;
    public int makeConnectedBetter(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        // 构建无向图 初始化
        graph = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }
        return res - 1;
    }

    private void dfs(int node) {
        visited[node] = true;
        for (Integer nei : graph[node]) {
            if (!visited[nei]) {
                dfs(nei);
            }
        }
    }



    public static void main(String[] args) {
        new leetcode1319_连通网络的操作次数().makeConnected(4,new int[][]{
                {0,1},{0,2},{1,2}
        });
    }
}
