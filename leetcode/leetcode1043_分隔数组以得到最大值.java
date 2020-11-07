import java.util.*;

public class leetcode1043_分隔数组以得到最大值 {
    //动态规划解法
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len=arr.length;
        int dp[]=new int[len+1]; //dp[i] 代表以前i个元素结束的分割数组最大和
        //注意是前
        for (int i = 1; i <len; i++) {
            int max=0;
            for (int j = i-1; j>=0 && i-j<=k; j--) {
                 max=Math.max(max,arr[j]);
                 dp[i]=Math.max(dp[i],max*(i-j)+dp[j]);
            }
        }
        return dp[len-1];
    }

    //记忆化搜索解法
    static  class Solution{
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int [] memo=new int[arr.length];
            Arrays.fill(memo,-1);
            return helper(memo,0,k,arr);
        }
        public int helper(int[] memo,int index,int k,int[] arr){
            if (index>arr.length-1) return 0;
            if (memo[index]!=-1) //若记忆录中有则直接返回
                return memo[index];
            int res=0;
            int maxval=0;
            for (int i = 0; i <k ; i++) { //从0开始，主要是包括index 单独成一个数组
                int nextid=index+i+1;
                if (index+i>=arr.length) break;
                maxval=Math.max(maxval,arr[index+i]);
                res=Math.max(res,helper(memo,nextid,k,arr)+maxval*(i+1));
            }

            memo[index]=res;
            return res;
        }
    }
}
