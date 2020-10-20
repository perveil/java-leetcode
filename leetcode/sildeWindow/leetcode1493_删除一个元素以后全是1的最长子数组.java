package sildeWindow;/*
  @Date:2020/10/20 10:59
  @Author:Administrator
*/

import java.util.*;

public class leetcode1493_删除一个元素以后全是1的最长子数组 {
    public int longestSubarray(int[] nums) {
        int left=0;
        int right=0;
        int res=0;
        int count=0; //0的计数器
        while(right<nums.length){
            if (nums[right]==0){
                count++;
            }
            //count>1 代表着窗口内的0有了两个，需要除去一个0
            while(left<right && count>1){
                if(nums[left] == 0){
                   count--;
                }
                left++;
            }
            res=Math.max(res,right-left);
            right++;
        }
        return res;
    }
}
