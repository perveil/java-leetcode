package 前缀和;/*
  @Date:2020/12/5 10:07
  @Author:Administrator
*/

import java.util.*;

public class leetcode560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0,1);
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }
}
