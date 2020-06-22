package leetcode.dp.完全背包;/*
  @Date:2020/5/4 11:56
  @Author:Administrator
*/

import java.util.*;

public class leetcode343_剪绳子 {
    int cuttingRope(int n) {
        int[]dp=new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) { //剪去的末尾长度    物品个数循环
            for (int j = i; j <= n; j++) { //绳子长度     体积循环
                dp[j] = Math.max(dp[j], dp[j-i] * i);
            }
        }
        return dp[n];
    }
}
