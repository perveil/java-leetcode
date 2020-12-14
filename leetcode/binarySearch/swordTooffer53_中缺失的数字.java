package binarySearch;/*
  @Date:2020/12/14 10:07
  @Author:Administrator
*/

import java.util.*;

public class swordTooffer53_中缺失的数字 {
    //查找i！=nums[i]的最左边界
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] !=mid)
                right=mid;  //mid已经搜索过了，但是搜索区间是左闭右开，所以right=mid
            else
                left = mid + 1; // 注意
        }
        return nums[left]-1>-1?nums[left]-1:0;
    }

    public static void main(String[] args) {
        new swordTooffer53_中缺失的数字().missingNumber(new int[]{
                1,2,3
        });
    }
}
