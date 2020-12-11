package graph.dfs;/*
  @Date:2020/12/1 8:59
  @Author:Administrator
*/

import java.util.*;

public class leetcode1306_跳跃游戏III {
    HashMap<Integer,Boolean> memo=new HashMap<>();
    public boolean canReach(int[] arr, int start) {
        if (arr.length<start) return false;
        boolean []marked=new boolean[arr.length]; //访问数组，已经访问过的就不再访问了
        return dfs(arr,start,marked);
    }
    public boolean dfs(int[] arr, int cur,boolean[]marked) {
        if (cur>=arr.length ||cur<0||marked[cur]){ //marked[cur]==true 已经访问过了，再访问说明存在循环，直接返回false
            return  false;
        }
        if (arr[cur]==0){
            return true;
        }
        marked[cur]=true;
        memo.put(cur, dfs(arr,cur+arr[cur],marked)||dfs(arr,cur-arr[cur],marked));
        return  memo.get(cur);
    }

    public static void main(String[] args) {
        new leetcode1306_跳跃游戏III().canReach(new int[]{
                4,2,3,0,3,1,2
        },5);
    }
}
