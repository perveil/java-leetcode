package dp;/*
  @Date:2020/11/23 10:25
  @Author:Administrator
*/

import java.util.*;

public class leetcode646_最长数对链 {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length<=1) return  pairs.length;
        //依据圆直径左测点排序，左测点相等的时候比较右侧点
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int len=pairs.length;
        int []dp=new int[len];
        dp[0]=1;
        int res=-1;
        for (int i = 1; i <len; i++) {
            dp[i]=dp[i-1]; //不要pair[i],初始化为dp[i-1]
            for (int j = i-1; j >-1; j--) {
                if (pairs[j][1]<pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode646_最长数对链().findLongestChain(new int[][]{
                {1,2},{2,3},{3,4}
        });
    }
}
