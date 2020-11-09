package sort.quicksort;
/*
  @Date:2020/11/9 8:37
  @Author:Administrator
*/

import java.util.*;

public class leetcode973_最接近原点的K个点 {
    static  class Node{
        int x;
        int y;
        int dis;
        public Node(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        if (K>points.length) return new int[][]{};
        Node [] nodes=new Node[points.length];
        for (int i = 0; i < points.length;i++) {
            nodes[i]=new Node(points[i][0],points[i][1],points[i][0]*points[i][0]+points[i][1]*points[i][1]);
        }
        Arrays.sort(nodes,(o1, o2) -> {
            return o1.dis-o2.dis;
        });
        int [][]res=new int[K][2];
        for (int i = 0; i <K ; i++) {
            res[i][0]=nodes[i].x;
            res[i][1]=nodes[i].y;
        }
        return res;
    }
}
