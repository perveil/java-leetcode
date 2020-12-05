package 前缀和;

import java.util.*;

public class leetcode1590_使数组和能使P整除 {
    //暴力O(n^2)求区间法，超时
    public int minSubarrayTimeOUT(int[] nums, int p) {
        long [] sums=new long[nums.length+1];
        long sum=0;
        for (int i = 1; i <=nums.length; i++) {
            sum+=nums[i-1];
            sums[i]=sum;
        }
        if (sum<p) return -1;   //数组和小于p直接返回-1
        if (sum%p==0) return 0; //数组和为p的整数倍，则不用删除
        int len=nums.length;
        int res=len;
        for (int i = 1; i <=len ; i++) {
            for (int j = i-1; j >=0; j--) {
                long remove =sums[i]-sums[j]; //去除 i...j-1 区间的数
                if ((sum-remove)%p==0){
                    res=Math.min(res,i-j);
                }
            }
        }
        return res==len?-1:res;
    }
    /*
        1 <= nums.length <= 105
        1 <= nums[i] <= 109
        1 <= p <= 109
    *
    * */
    public int minSubarray(int[] nums, int p) {
            //求前缀和
            int len=nums.length;
            long sum=0;
            for (int i = 0; i <len; i++) {
                sum+=nums[i];
            }
            if (sum%p==0) return 0;
            if (sum<p) return -1; //不可能
            // 求前缀和
            long[] prefixSum = new long[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
            long rest=sum%p; //寻找数组和%p==rest的子数组，整体数组减去该子数组
            int res=nums.length;
            Map<Long,Integer> map=new HashMap<>(); // sum[0...i]%p为Key的子数组左侧边界
            for (int i = 0; i <=len ; i++) { //从前向后遍历
                Integer index=map.get((prefixSum[i]-rest)%p);
                if (index!=null){
                    res=Math.min(res,i-index);
                }
                map.put(prefixSum[i]%p,i); //将右侧边界赋值给左侧边界

            }
            return res==nums.length?-1:res;
        }

    public static void main(String[] args) {
        new leetcode1590_使数组和能使P整除().minSubarray(new int[]{
               1,1,1
        },2);
    }
}
