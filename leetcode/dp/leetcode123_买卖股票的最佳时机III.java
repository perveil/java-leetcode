package dp;/*
  @Date:2020/11/8 9:38
  @Author:Administrator
*/

import java.util.*;
/*
* 在leetcode_122的基础上加一个限制条件：最多完成两笔交易
* */
public class leetcode123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][][] dp = new int[len][2][3];
        /*
        * 第一维是交易日
        * 第二维是该交易日持有还是不持有
        * 第三维是进行了几次交易，0，1，2
        * dp[i][0][j] :第i天交易了j次，不持有股票，持有现金时的最大现金
        * */
        //初始化,第一天
        for (int i = 0; i <3 ; i++) {
            dp[0][1][i]=-prices[0]; //持有股票，利润为-price[0]
            dp[0][0][i]=0; //持有现金，处于观望
        }
        for (int i = 1; i <len ; i++) {
            //第i天进行j次交易
            for (int j = 2; j > 0; j --) { //j=0不进行交易
                //第i天持有现金=第i-1天也持有现金，处于观望,交易次数不变 ||第i-1天持有股票，第i天卖出，交易次数+1
                dp[i][0][j]=Math.max(dp[i-1][0][j],dp[i-1][1][j]+prices[i]);
                //第i天持有股票=第i-1天也持有股票，处于观望,交易次数不变 ||第i-1天持有现金，第i天买入，交易次数+1
                dp[i][1][j]=Math.max(dp[i-1][1][j],dp[i-1][0][j-1]-prices[i]);
                //为什么j-1？
            }
        }
        return Math.max(dp[len-1][0][0],Math.max(dp[len-1][0][1],dp[len-1][0][2]));
    }
}
