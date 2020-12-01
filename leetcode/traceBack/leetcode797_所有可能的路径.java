package traceBack;/*
  @Date:2020/12/1 10:19
  @Author:Administrator
*/

import java.util.*;

public class leetcode797_所有可能的路径 {
    //给定有向无环图,无备忘录
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean marked[] =new boolean[graph.length];
        List<Integer> path =new LinkedList<>();
        path.add(0); //第一个节点入队
        dfs(graph,0,graph.length-1,path);
        return res;
    }
    public void dfs(int [][]graph,int cur,int target,List<Integer> path){
        if (cur==target){
            res.add(new ArrayList<>(path));
            return; //递归结束
        }
        for (int i :graph[cur]) {
            path.add(i);
            dfs(graph,i,target,path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        new leetcode797_所有可能的路径().allPathsSourceTarget(new int[][]{
                {4,3,1},{3,2,4},{3},{4},{}
        });
    }

}
