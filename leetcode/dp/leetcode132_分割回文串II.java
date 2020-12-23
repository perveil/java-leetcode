package dp;/*
  @Date:2020/12/21 16:28
  @Author:Administrator
*/

import java.util.*;

public class leetcode132_分割回文串II {
    //标准 dp
    public int minCut(String s) {
        int len=s.length();
        if (len < 2) {
            return 0;
        }
        int dp[]=new int[len]; //dp[i]: s[0:i] 所表示的字符串全部分割成回文串所需要的最小分割次数
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <len ; i++) {
            if (isPalindrome(s,0,i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = i-1; j >-1 ; j--) {
                if (isPalindrome(s,j+1,i)){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return  dp[len-1];
    }
    public boolean isPalindrome(String s,int left,int right) {
        int i = left, j =right;
        while(i < j){
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }
    public int minCutOfBetter(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return 0;
        }
        //初始化
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        // 数据预处理,checkPalindrome 直接记录[j,i] 之间的字符串是不是回文字符串
        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }
        for (int i = 1; i <len ; i++) {
            if (isPalindrome(s,0,i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = i-1; j >-1 ; j--) {
                if (checkPalindrome[j+1][i]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1];

    }
    public static void main(String[] args) {
        new leetcode132_分割回文串II().minCut("aab");
    }
}
