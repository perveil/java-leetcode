package dp;/*
  @Date:2021/1/6 21:50
  @Author:Administrator
*/

import java.util.*;
//参考解析
// https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
public class leetcode32_最长有效括号 {
    int longestValidParentheses(String s) {
        int size = s.length();
        int []dp=new int[size];
        int maxVal = 0;
        for(int i = 1; i < size; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = 2+ dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) { // 以s.charAt(i-1) 为末尾的最长有效括号长度
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxVal =Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

}
