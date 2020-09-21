package 软微上机测试;
/*
  @Date:2020/9/19 13:54
  @Author:Administrator
*/

import java.util.*;

public class problem1 {
    public static void main(String[] args) {
        // 输入
        Scanner reader = new Scanner(System.in) ;
        while(reader.hasNext())
        {
            int m = reader.nextInt() ;
            if (m==0){
                break;
            }
            int [] numbers = new int[m] ;
            for(int index=0;index<m;index++)
            {
                numbers[index] = reader.nextInt();
            }

            //动态规划
            int[] dp = new int[m];
            dp[0] = numbers[0];
            int max = dp[0];
            for(int i=1;i < m;i++){
                dp[i] = Math.max(dp[i-1] + numbers[i],numbers[i]);
                max = Math.max(max,dp[i]);
            }
            System.out.println(max);
        }
    }
}
