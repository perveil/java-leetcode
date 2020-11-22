package dp;
/*
  @Date:2020/11/20 10:26
  @Author:Administrator
*/

import java.util.*;

public class leetcode376_摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        int len=nums.length;
        if (len<=1) return len;
        if(isAllsimilar(nums)) return 1; //全相等
        int dp[]=new int[len+1];  //dp[i] 表示以第i个元素为末尾元素的最长的摆动子序列长度
        int ans[]=new int[len+1]; //ans[i] 表示以第i个元素为末尾元素的最长的摆动子序列的最后一个状态是1、-1、0
        //dp 初始化，从1开始
        dp[1]=2;
        ans[1]=nums[1]>nums[0]?1:(nums[1]<nums[0]?-1:0);
        int maxlen=2;
        for(int i=2;i<len;i++){
            dp[i]=2;
            ans[i]=nums[i]>nums[i-1]?1:(nums[i]<nums[i-1]?-1:0);
            for (int j = i-1; j >0 ; j--) {
                if ((nums[i]-nums[j])*ans[j]<0 ){
                    if (dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        ans[i]=nums[i]>nums[j]?1:(nums[i]<nums[j]?-1:0);
                    }
                }

            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
    boolean isAllsimilar(int A[]){
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode376_摆动序列().wiggleMaxLength(new int[]{0,0});
    }
}
