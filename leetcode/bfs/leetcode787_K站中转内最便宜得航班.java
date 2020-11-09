package bfs;
/*
  @Date:2020/11/8 19:37
  @Author:Administrator
*/

import java.util.*;

public class leetcode787_K站中转内最便宜得航班 {
    static  class Node{
        int start;
        int end;
        public Node(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return start == node.start &&
                    end == node.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
    int minlen=Integer.MAX_VALUE;
    Map<Node,Integer> map; //边与距离的映射
    Map<Integer,Boolean> marked;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int len=flights.length;
        map=new HashMap<>();
        marked=new HashMap<>();
        Map<Integer,List<Integer>> point2list=new HashMap<>(); //邻接矩阵
        for (int i = 0; i <len ; i++) {
            map.put(new Node(flights[i][0],flights[i][1]),flights[i][2]);
            if (!point2list.containsKey(flights[i][0])){ //不包含则直接插入一个数组
                point2list.put(flights[i][0],new ArrayList<>());
            }
            point2list.get(flights[i][0]).add(flights[i][1]);
        }
        helper(point2list,marked,src,dst,K+1,0);
        return minlen;
    }
    public void helper(Map<Integer,List<Integer>> point2list, Map<Integer,Boolean> marked,int src, int dst, int K,int curDis) {
        if (K<0) return;
        if (K>=0 && src==dst){
            Math.min(curDis,minlen);
            return;
        }
        marked.put(src,true);
        if (point2list.get(src)==null) return; //src 与dst之间没有航班，直接返回
        for (int i:point2list.get(src)) {
            if (!marked.containsKey(i)&& map.containsKey(new Node(src,i))){
                helper(point2list,marked,i,dst,K-1,curDis+map.get(new Node(src,i)));  //递归
            }
        }
        marked.put(src,false); //回溯
    }

    public static void main(String[] args) {
        new leetcode787_K站中转内最便宜得航班().findCheapestPrice(3,new int [][]{
                {0,1,100},{1,2,100},{0,2,500}
        },1,2,1);
    }
}
