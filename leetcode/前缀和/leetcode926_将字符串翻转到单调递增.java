package 前缀和;/*
  @Date:2020/12/13 22:15
  @Author:Administrator
*/

import java.util.*;

public class leetcode926_将字符串翻转到单调递增 {
    public int minFlipsMonoIncr(String S) {
        int n=S.length();
        int[] presum=new int[n+1]; //persum[i]=num[0]+..+num[i-1] persum[0]=0;
        int sum=0;
        for (int i = 1; i <=n ; i++) {
            sum+=S.charAt(i-1)-'0';
            presum[i]=sum;
        }
        int res=n;
        for (int i = 0; i <=n ; i++) {
            //System.out.println(presum[i]+n-i-(presum[n]-presum[i]));
            res=Math.min(res,presum[i]+n-i-(presum[n]-presum[i]));
            //翻转前边的1 的次数 presum[i]
            //翻转后边的0 的次数 n-i+1-(persum[n]-persum[i])
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode926_将字符串翻转到单调递增().minFlipsMonoIncr("1110");
    }
}
