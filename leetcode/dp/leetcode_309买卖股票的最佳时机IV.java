package dp;/*
  @Date:2020/11/8 16:10
  @Author:Administrator
*/

import java.util.*;

public class leetcode_309买卖股票的最佳时机IV {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][3];
        //dp[i][0]  第i天持有cash
        //dp[i][1]  第i天持有stock
        //dp[i][2]  表示，第i天卖出股票，i+1天进入冷冻期
        dp[0][0]=0; //起始第一天持有cash，利润为0
        dp[0][1]=-prices[0];  //第一天购入股票，利润则为-prices[0]
        dp[0][2] = 0;   //第一天不可能是过渡期，初始化为0
        for (int i = 1; i <len; i++) {
            //第i天持有cash = 第i天是冷冻期(i-1天卖出) ||  第i-1天持有cash，处于观望状态
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
            //第i天持有股票=第i天买股票（前一天持有cash或者处于冷冻期）||第i-1天也持有股票，处于观望状态
            dp[i][1]=Math.max(dp[i-1][1],dp[i - 1][0] - prices[i]);
            //第i天卖出股票（i+1 成为冷冻期）=i-1天持有股票
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[len-1][0],dp[len-1][2]); //最后一天持有cash
    }
}
