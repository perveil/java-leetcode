package 前缀和;

import java.util.*;

public class leetcode525_连续数组 {
    public int findMaxLength(int[] nums) {
        int start=0;
        int end=0;
        HashMap<Integer,Integer> leftIndexMap=new HashMap<>();//key：前缀和，value：和为key的最左索引
        leftIndexMap.put(0, -1); //初始化
        int preSum=0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i]==1 ? 1 : -1; //字母象征着-1，数字象征着1
            if (!leftIndexMap.containsKey(preSum)) {
                leftIndexMap.put(preSum,i);
            }else{
                int leftIndex = leftIndexMap.get(preSum);
                if (i-leftIndex>end-start){
                    start=leftIndex;
                    end=i;
                }
            }
        }
        return end-start;
    }
}
