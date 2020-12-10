package unionFind;/*
  @Date:2020/12/9 19:46
  @Author:Administrator
*/

import java.util.*;

public class leetcode1319_联通网络的操作次数 {
    class DSU {
        int[] parent;
        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) //初始化时，每个节点的父节点是自己本身
                parent[i] = i;
        }
        public int find(int x) { //找x的父节点
            if (parent[x] != x) parent[x] = find(parent[x]);  // 如果x的父节点不是x本身，则去找x的父节点的父节点...向下递归
            return parent[x];
        }
        public void union(int x, int y) { //合并x与y，把x集合的父节点指向y的父节点
            parent[find(x)] = find(y);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int N = connections.length; //边数
        if(n-1>N){ //边数小于节点数-1时,返回-1
            return -1;
        }
        DSU dsu=new DSU(n);
        for (int i = 0; i <connections.length ; i++) {
            dsu.union(connections[i][0],connections[i][1]); //合并两个点
        }
        Set<Integer> parentsNum=new HashSet<>();
        for (int  i=0;i<n;i++) {
            parentsNum.add(dsu.find(i));
        }
        return parentsNum.size()-1;
    }
}
