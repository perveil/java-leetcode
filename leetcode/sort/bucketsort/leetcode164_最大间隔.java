package sort.bucketsort;
/*
  @Date:2020/10/6 16:40
  @Author:Administrator
*/

import java.util.*;
/*
*  problem1： n 个数为什么要分配n+1个桶: 最小数在第一个桶里，最大数在最后一个桶里，分配n+1个桶保证了一定有一个空桶
*    0-(n-1) 的桶区间内，一定有一个空桶，不管空桶出现在哪个位置（1号桶、2-（n-2）号桶、n-1 号桶）,都保证了最大间距不在桶内，而在桶之间
*  problem2：桶的映射公式： bucket index=(int) (nums[i]-min)*len /(max-min)
*
* */
public class leetcode164_最大间隔 {
    public int maximumGap(int[] nums) {
        if (nums == null||nums.length<2){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int len=nums.length;
        for (int num: nums) {
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        if (max==min){
            return 0;
        }
        //准备n+1个桶
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int bid = bucket_index(nums[i], min, max,len);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0, preMax = maxs[0]; //初始化为第一个桶的最大值
        for (int i = 1; i <= len; i++) { //从第二个桶开始遍历,遍历到第n+1个桶
            if (hasNum[i]) { // 是非空的
                res = Math.max(res, mins[i] - preMax);
                preMax = maxs[i];
            }
        }
        return  res;

    }
    public int bucket_index(int num,int min,int max,int len){
        int d = Math.max(1, (max - min) / (len- 1));
        return  ((num - min)/d);
    }
}
