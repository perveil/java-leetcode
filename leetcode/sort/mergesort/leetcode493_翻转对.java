package sort.mergesort;/*
  @Date:2020/12/16 9:57
  @Author:Administrator
*/

import java.util.*;

public class leetcode493_翻转对 {
    public int reversePairs(int[] nums) {
        int len=nums.length;
        long [] numsLong=new long[len];
        for (int i = 0; i <len ; i++) {
            numsLong[i]=nums[i];
        }
        if(len<2){
            return 0;
        }
        return reversePairs(numsLong, 0, len - 1);
    }
    private int reversePairs(long[] nums, int left, int right) {
        if(left==right){
            return  0;
        }
        int mid=(left+right)>>1;
        int leftPairs=reversePairs(nums,left,mid);
        int rightPairs=reversePairs(nums,mid+1,right);
        int reversePairs=leftPairs+rightPairs;
        int reverseCrossPairs = 0; //两侧逆序对数
        int i=left; //左侧左边界
        int j=mid+1; //右侧左边界
        //固定左侧数组中的某一个数字nums[k]，去右侧数组中找到的nums[q]满足条件: nums[k]<=2*nums[q],此时mid+1...k-1
        for (; i <= mid; i++) {
            for (; j <=right ; j++) {
                if (nums[i]<=2*nums[j]){
                    break;
                }
            }
            reverseCrossPairs=reverseCrossPairs+(j-mid-1);
        }
        long[] sorted = new long[right - left + 1]; //中间数组
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] =  nums[p2++];
            } else if (p2 > right) {
                sorted[p++] = nums[p1++];
            } else {
                if (nums[p1] < nums[p2]) {
                    sorted[p++] =  nums[p1++];
                } else {
                    sorted[p++] = nums[p2++];
                }
            }
        }
        //将排序之后的中间数组复制到本来的数组中去
        for (int k = 0; k < sorted.length; k++) {
            nums[left + k] = sorted[k];
        }
        return reversePairs + reverseCrossPairs;
    }

    public static void main(String[] args) {
//        new leetcode493_翻转对().reversePairs(new int[]{
//                2147483647,2147483647,2147483647,2147483647,2147483647,2147483647
//        });

    }
}
