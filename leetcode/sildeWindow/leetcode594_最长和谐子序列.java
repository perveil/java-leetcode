package sildeWindow;
/*
  @Date:2020/9/23 15:33
  @Author:Administrator
*/

import java.util.*;

public class leetcode594_最长和谐子序列 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int right=0,left=0;
        int res=0;
        while(right<nums.length){
            //不满足条件时
            while(left<right &&nums[right]-nums[left]>1){
                left++;
            }
            //满足条件时
            if(nums[right]-nums[left]==1){
                res=Math.max(res,right-left+1);
            }
            right++;
        }
        return res>1?res:0;
    }

    public static void main(String[] args) {
        new leetcode594_最长和谐子序列().findLHS(new int[]{
                1,4,1,3,1,-14,1,-13
        });
    }
}
