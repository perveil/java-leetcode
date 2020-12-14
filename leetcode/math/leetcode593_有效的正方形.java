package math;/*
  @Date:2020/12/14 9:17
  @Author:Administrator
*/

import java.util.*;
/*
* 正方形四条边相等，是个菱形
* 正方形对角线相等
* */
public class leetcode593_有效的正方形 {
    //tips：输入点没有顺序
    //解法1：四条边的长度相等，两条对角线的长度相等
    /*
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set=new HashSet<>();
        set.add(distanceSquare(p1, p2));
        set.add(distanceSquare(p1, p3));
        set.add(distanceSquare(p1, p4));
        set.add(distanceSquare(p2, p3));
        set.add(distanceSquare(p2, p4));
        set.add(distanceSquare(p3, p4));
        return set.size() == 2 && !set.contains(0);
    }
    private static int distanceSquare(int[] a, int[] b) {
        int i = a[0] - b[0];
        int j = a[1] - b[1];
        return i * i + j * j;
    }
    * */
    //解法2：对于每一个点到其他三个点距离，dis1、dis2、dis3 存在某个distance 是其他两个distance平方的根号
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return distanceSquare(p1,p2,p3)&distanceSquare(p1,p2,p4)&distanceSquare(p1,p3,p4)&distanceSquare(p2,p3,p4);
    }
    private static boolean distanceSquare(int[] a, int[] b,int []c) {
        Set<Integer> set=new HashSet<>();
        set.add((a[0] - b[0])*(a[0] - b[0])+(a[1] - b[1])*(a[1] - b[1]));
        set.add((a[0] - c[0])*(a[0] - c[0])+(a[1] - c[1])*(a[1] - c[1]));
        set.add((c[0] - b[0])*(c[0] - b[0])+(c[1] - b[1])*(c[1] - b[1]));
        if(set.size()!=2) return false;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (Integer i:set) {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        return min*2==max;
    }

    public static void main(String[] args) {
        new leetcode593_有效的正方形().validSquare(new int[]{
                0,0
        },new int[]{
                1,1
        },new int[]{
                1,0
        },new int[]{
                0,1
        });
    }

}
