package dp;/*
  @Date:2020/11/2 22:15
  @Author:Administrator
*/

import java.util.*;

public class leetcode403_青蛙过河 {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        boolean[][] dp = new boolean[len][len + 1];
        //dp[i][k] 表示能否由前面的某一个石头 j 通过跳 k-1，k，k+1 长的距离到达当前这个石头 i ，这个 j 的范围是 [1, i - 1]
        if(stones[0]!=0||stones[1] != 1){
            return false;
        }
        dp[0][0] = true; //初始化，初始的时候，通过0的距离跳到第0块石头
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                int k = stones[i] - stones[j];
                if(k-1 <= j){ //k-1 是 第j块石头，可以到的最左的位置
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    if(i == len - 1 && dp[i][k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
