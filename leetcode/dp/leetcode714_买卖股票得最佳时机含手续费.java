package dp;
/*
  @Date:2020/11/8 19:22
  @Author:Administrator
*/

import java.util.*;

public class leetcode714_买卖股票得最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        //dp[i][0]  第i天持有cash
        //dp[i][1]  第i天持有stock
        dp[0][0]=0; //起始第一天持有cash，利润为0
        dp[0][1]=-prices[0];  //第一天购入股票，利润则为-prices[0]
        for (int i = 1; i <len; i++) {
            //第i天持有cash = 第i天卖掉股票（第i-1天持有） ||  第i-1天不持有，处于观望状态
            dp[i][0]=Math.max(dp[i-1][0],dp[i - 1][1] + prices[i]-fee);
            //第i天持有股票=第i天买股票（前一天持有cash）||第i-1天也持有股票，处于观望状态
            dp[i][1]=Math.max(dp[i-1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[len-1][0]; //最后一天持有cash
    }
}
