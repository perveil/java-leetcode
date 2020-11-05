package dp;/*
  @Date:2020/11/5 23:46
  @Author:Administrator
*/

import java.util.*;

public class leetcode978_最长湍流子数组 {
    public int maxTurbulenceSize(int[] A) {
        int compare[]=new int[A.length-1];
        if(isAllsimilar(A)) return 1; //全相等
        for(int i=1;i<A.length;i++){
            compare[i-1]=A[i]>A[i-1]?1:(A[i]<A[i-1]?-1:0);
        }
        //1(<) 0(=) -1(>)
        int dp[]=new int[A.length];
        dp[0]=2; //至少是1
        int maxlen=1;
        for(int i=1;i<compare.length;i++){
            if(compare[i]*compare[i-1]<0){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=2;
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
    boolean isAllsimilar(int A[]){
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[i-1]){
                return false;
            }
        }
        return true;
    }
}
