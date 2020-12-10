package 前缀和;/*
  @Date:2020/12/10 19:15
  @Author:Administrator
*/

import java.util.*;

public class leetcode327_区间和的个数 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return helper(sum, lower, upper, 0, sum.length - 1);
    }
    /*
    *  设前缀和数组为perSum, 问题转化为:lower<=(perSum[j]-perSum[i])<=upper
    *  给定两个升序数组n1 n2 ,试找出所有的下标对（j,i）,满足lower<=(n2[j]-n1[i])<=upper
    *  做法1：以n1数组中的每一个数为基准，在n2中寻找l,r 使得 lower<=n2[l]-n1[i] && n2[r]-n1[i] > upper
    *  做法2：以n2数组中的每一个数为基准，在n1中寻找l,r 使得 lower <=n2[i]-n1[l] && n2[i]-n1[r] > upper
    *
    *  使用归并排序：先切分再合并
    * */
    public int helper(long [] sum,int lower,int upper,int start,int end){
        if (start==end){
            return 0;
        }
        //切分
        int mid=(start+end)/2;
        int n1=helper(sum,lower,upper,start,mid);
        int n2=helper(sum, lower, upper, mid + 1, end);
        int res=n1+n2;
        //做处理
        int i=start; //n1 数组的遍历指针
        int l=mid+1; //n2 数组的左侧指针
        int r=mid+1; //n2 数组的右侧指针
        while(i<=mid){
            while (l <= end && sum[l] - sum[i] < lower) l++;
            while (r <= end && sum[r] - sum[i] <= upper) r++;
            res+=(r-l);
            i++;
        }
        //合并
        int[] sorted = new int[end - start + 1];
        int p1 = start, p2 = mid + 1;
        int p=0;
        while (p1<=mid || p2<=end){
            if (p1>mid){ //n1 遍历提前结束
                sorted[p++]=(int) sum[p2++];
            }else if (p2>end){ //n2 遍历提前结束
                sorted[p++]=(int) sum[p1++];
            }else{ //n1 和n2 都没有结束
                if (sum[p1]<sum[p2]){
                    sorted[p++]=(int) sum[p1++];
                }else{
                    sorted[p++]=(int) sum[p2++];
                }
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            sum[start + j] = sorted[j];
        }
        return res;
    }
}
