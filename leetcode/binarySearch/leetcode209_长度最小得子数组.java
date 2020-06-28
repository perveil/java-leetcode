package binarySearch;
/*
  @Date:2020/6/28 9:49
  @Author:Administrator
*/

import java.util.*;
/*
*  前缀和+二分查找
*  前缀和=》sum[i]=\sum{0}{i-1} nums[j] 变为有序
* */
public class leetcode209_长度最小得子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int sums[]=new int[n+1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <=n ; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target); //找到第一个大于target的数的位置
            if (bound < 0) { //左侧溢出，
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
