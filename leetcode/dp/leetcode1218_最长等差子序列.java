package dp;/*
  @Date:2020/12/9 21:57
  @Author:Administrator
*/

import java.util.*;

public class leetcode1218_最长等差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        if (arr.length==1) return 1;
        int res=1;
        int n=arr.length;
        int []dp=new int[n];
        Arrays.fill(dp,1);
        dp[0]=1; //初始化
        Map<Integer,Integer> map=new HashMap<>();
        map.put(arr[0],1);
        for (int i = 1; i <n; i++) {
             if (map.containsKey(arr[i]-difference)){
                 dp[i]=1+map.get(arr[i]-difference);
             }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1218_最长等差子序列().longestSubsequence(new int[]{
                1,5,7,8,5,3,4,2,1
        },-2);
    }
}
