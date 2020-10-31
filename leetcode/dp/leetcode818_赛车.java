package dp;
/*
  @Date:2020/10/23 11:27
  @Author:Administrator
*/

import java.util.*;

public class leetcode818_赛车 {
/*
当向前走时，R指令到达，速度变为反方向的-1，此时位置不变 <==> 完成了掉头，且反方向速度为1
当向后走时，R指令到达，速度变为正方向的1，此时位置不变 <==>完成了掉头，且正方向速度为1
*/
    public int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1; dp[2] = 4;

        for (int t = 3; t <= target; ++t) {
            int k = 32 - Integer.numberOfLeadingZeros(t); // 2^{k-1}-1 <= x < 2^k  找到 k
            if (t == (1<<k) - 1) { //if x = 2^{k}-1 ，直接就到了
                dp[t] = k;
                continue;
            }
            for (int j = 0; j < k-1; ++j) //只到了t的左侧，存在可能先折返一段路程再向前
                dp[t] = Math.min(dp[t], dp[t - (1<<(k-1)) + (1<<j)] + k-1 + j + 2);
            if ((1<<k) - 1 - t < t)     //到了t的右侧，此时需要折返
                dp[t] = Math.min(dp[t], dp[(1<<k) - 1 - t] + k + 1);
        }

        return dp[target];
    }
}
