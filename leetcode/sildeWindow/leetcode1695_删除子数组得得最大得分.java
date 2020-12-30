package sildeWindow;/*
  @Date:2020/12/30 9:59
  @Author:Administrator
*/

import java.util.*;

public class leetcode1695_删除子数组得得最大得分 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> curset=new HashSet<>();
        int cursum=0;
        int res=-1;
        int r=0;
        int l=0;
        int len=nums.length;
        while(r<len){
            while(l<=r&&curset.contains(nums[r])){
                cursum-=nums[l];
                curset.remove(nums[l]);
                l++;
            }
            cursum+=nums[r];
            curset.add(nums[r]);
            res=Math.max(res,cursum);
            r++;
        }
        return res;
    }
}
