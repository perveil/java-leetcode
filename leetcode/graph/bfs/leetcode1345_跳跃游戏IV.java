package graph.bfs;/*
  @Date:2020/12/1 9:26
  @Author:Administrator
*/

import java.util.*;

public class leetcode1345_跳跃游戏IV {
    public int minJumps(int[] arr) {
        if (arr.length==1) return 0;
        Map<Integer,List<Integer>> keymap=new HashMap<>(); //相同的数字在数组中出现的索引集合
        Map<Integer,Set<Integer>> map=new HashMap<>();    //key可以到达的下一个位置，邻接矩阵
        for (int i = 0; i < arr.length; i++) {
            if (!keymap.containsKey(arr[i])){
                keymap.put(arr[i],new ArrayList<>());
            }
            keymap.get(arr[i]).add(i);
        }

        for (int i = 0; i <arr.length ; i++) {
            Set<Integer> aimList=new HashSet<>();
            if(i-1>-1) aimList.add(i-1);
            if(i+1<arr.length) aimList.add(i+1);
            for (Integer j:keymap.get(arr[i])) {
                if (i!=j){
                    aimList.add(j);
                }
            }
            map.put(i,aimList);
        }
        return  bfs(arr,map);
    }
    public int bfs(int[] arr,Map<Integer,Set<Integer>>  map) {
        boolean [] marked=new boolean[arr.length];
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(0);
        marked[0]=true;
        int res=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                int cur=queue.poll();
                if (cur==arr.length-1){ //找到了目标值
                    return res;
                }
                for (int j:map.get(cur)) {
                    if (!marked[j]){
                        queue.add(j);
                        marked[j]=true;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        new leetcode1345_跳跃游戏IV().minJumps(new int[]{
                7
        });
    }
}
