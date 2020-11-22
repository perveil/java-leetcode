package sort.bucketsort;
/*
  @Date:2020/11/20 9:43
  @Author:Administrator
*/

import java.util.*;

public class leetcode1365_有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count[]=new int[101];
        int len=nums.length;
        for (int i = 0; i <len; i++) { //此时桶里边是nums[i]出现的次数
            count[nums[i]]++;
        }
        int sum=0;
        for (int i = 0; i <101 ; i++) { //此时桶里边是小于i的元素个数
           int temp=count[i];
           count[i]=sum; //先改
           sum+=temp;  //后加，类似于前缀和
        }
        int []res=new int[len];
        for (int i=0;i<len;i++) {
            res[i]=count[nums[i]];
        }
        return res;
    }
}
