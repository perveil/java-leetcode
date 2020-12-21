package dp;/*
  @Date:2020/12/21 10:20
  @Author:Administrator
*/

import java.util.*;

public class leetcode746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        //此题可以转换为在索引位置为-1的位置，然后走一步或者走两步的动态选择问题
        int dp[]=new int[cost.length];
        int len =cost.length;
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<len;i++){
            dp[i]=Math.min(dp[i-2]+cost[i],dp[i-1]+cost[i]);
        }
        return Math.min(dp[len-1],dp[len-2]);
    }

    public static void main(String[] args) {
        new leetcode746_使用最小花费爬楼梯().minCostClimbingStairs(new int[]{
                1, 100, 1, 1, 1, 100, 1, 1, 100, 1
        });
    }
}
