package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
*
* */
public class leetcode122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])  //寻找valley
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])  //寻找peek
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        List<Integer> list=new ArrayList<>();
        return maxprofit;
    }
    /*
    *  动态规划，每一天只有两个状态，不持有股票和持有股票
    *  今天持有股票：昨天持有股票且今天不卖出去 、昨天买入，今天不卖
    *   今天不持有股票：昨天卖出、昨天不持有
    * */
    public int maxProfit_dp(int[] prices) {
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
            dp[i][0]=Math.max(dp[i-1][0],dp[i - 1][1] + prices[i]);
            //第i天持有股票=第i天买股票（前一天持有cash）||第i-1天也持有股票，处于观望状态
            dp[i][1]=Math.max(dp[i-1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[len-1][0]; //最后一天持有cash

    }

}
