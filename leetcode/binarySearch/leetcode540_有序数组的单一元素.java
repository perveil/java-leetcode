package binarySearch;
/*
  @Date:2020/9/21 10:24
  @Author:Administrator
*/

import java.util.*;

public class leetcode540_有序数组的单一元素 {
    // tips:目标值在奇数侧
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){ //结束条件left==right
            int mid=(left+right)/2; //中间取mid
            if((mid-1>=left&&nums[mid]!=nums[mid-1])&&
                    (mid+1<=right&&nums[mid]!=nums[mid+1])){
                return nums[mid];
            } else if(mid-1>=left&&nums[mid]==nums[mid-1]){ //中点值==中点左侧值
                if((mid-left)%2==0){
                    right=mid-2;
                }else{
                    left=mid+1;
                }
            }else if(mid+1<=right&&nums[mid]==nums[mid+1]){  //中点值==中点右侧值
                if((right-mid)%2==0){
                    left=mid+2;
                }else{
                    right=mid-1;
                }
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        new leetcode540_有序数组的单一元素().singleNonDuplicate(new int[]{
                1,1,2,3,3,4,4,8,8
        });
    }
}
