package graph.dfs;
/*
  @Date:2020/10/6 15:54
  @Author:Administrator
*/

import java.util.*;
/*
* 对于两个相邻节点A和B，将树拆分为两个子树，根节点分别为A和B，A节点到其他所有节点的距离和ans(A) = A子树中所有节点到A节点的距离和sum(A) + B子树中所有节点到B节点的距离和sum(B) + B子树的大小cnt(B);同理，ans(B) = sum(B) + sum(A) + cnt(A);

由此我们得到：
ans(A) = sum(A) + sum(B) + cnt(B);
ans(B) = sum(B) + sum(A) + cnt(A);

则，两个相邻接点的解之间的关系为：ans(A) = ans(B) - cnt(A) + cnt(B) = ans(B) - cnt(A) + (N - cnt(A));

因此，对于根节点root的任意子节点child，ans(child) = ans(root) - cnt(child) + N - cnt(child);
* */
public class leetcode834_树中的距离 {
    int [] ans;
    int [] cnt;
    List<ArrayList<Integer>> graph;
    int n=0;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans=new int[N];
        cnt=new int[N];
        graph=new ArrayList<>();
        for (int i = 0; i <N; i++) {
            graph.add(new ArrayList<>());
        }
        n=N;
        Arrays.fill(cnt,1);
        for(int[] e:edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        //以上为初始化过程
        dfs(0,-1);
        dfs2(0,-1);
        return ans;
    }
    //从0开始通过累加得到根节点0到其他所有节点的距离之和
    void dfs(int child, int parent) {
        for (int i = 0;i < graph.get(child).size(); i++) {
            if (graph.get(child).get(i) != parent) {//这里必须要判断，parent和child的子节点可能存在边关系，会造成重复计算，也会造成死循环
                dfs(graph.get(child).get(i),child);
                cnt[child] += cnt[graph.get(child).get(i)];
                ans[child] += ans[graph.get(child).get(i)] + cnt[graph.get(child).get(i)];
                //某个节点的距离和等于其各个子树的和+子树的大小
            }
        }
    }
    //从0开始通过ans(child) = ans(root) - cnt(child) + N - cnt(child)得到各节点到其他所有节点的距离之和
    void dfs2(int child, int parent) {
        for (int i = 0; i <  graph.get(child).size(); i++) {
            if(parent != graph.get(child).get(i)) {
                ans[graph.get(child).get(i)]  = ans[child] -2*cnt[graph.get(child).get(i)] + n;//先计算出根节点的子节点，然后再递归去算子节点的子节点
                dfs2(graph.get(child).get(i),child);
            }
        }
    }



}
