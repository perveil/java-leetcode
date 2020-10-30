package dp;/*
  @Date:2020/10/24 10:01
  @Author:Administrator
*/

import java.util.*;

public class leetcode1024_视频拼接 {
    public int videoStitching(int[][] clips, int T) {
        int dp[]=new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0; //dp[i] 指的是覆盖0-i这个区间需要的最少区间数
        for (int i = 1; i <=T ; i++) {
            for (int [] clip: clips) {
                if (clip[0]<i && i<=clip[1]){  // i (clip[0],clip[1] ]
                    dp[i]=Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[T]==Integer.MAX_VALUE?-1:dp[T];
    }
}
