package binarySearch;
/*
  @Date:2020/12/13 15:41
  @Author:Administrator
*/

import java.util.*;
/*
* 1.区间的起始点小于其终点
* 2.这些区间都不会具有相同的起始点
*
* */
public class leetcode436_寻找右区间 {
    //满足最小左边界的右区间
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int res[]=new int[n];
        Map<Integer,Integer> map=new HashMap<>(); //为起始点为key的区间索引是value
        int startPoint[]=new int[n];
        for (int i=0;i<n;i++) {
            map.put(intervals[i][0],i);
            startPoint[i]=intervals[i][0];
        }
        Arrays.sort(startPoint);
        for (int i = 0; i <n; i++) {
            int endPoint=intervals[i][1]; //寻找比endPoint 大或等于的Startpoint
            //二分查找,查找第一个大于或等于endPoint的startPoint
            //寻找左侧边界的二分查找
            //得出的结果l 代表startPoint中小于endPoint的数的个数，则startPoint[l]>=startPoint
            int l=0;
            int r=n; //[l,r)
            while(l<r){ // l>=r 时退出
                int mid=(l+r)/2;
                if (startPoint[mid]>=endPoint){
                    r=mid; //而不是r=mid-1
                }else {
                    l=mid+1;
                }
            }
            //
            if (l==n) res[i]=-1;
            else res[i]=map.get(startPoint[l]);
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode436_寻找右区间().findRightInterval(new int[][]{
                {1,4},{2,3},{3,4}
        });
    }
}
