package 前缀和;

import java.util.*;

public class Interview1705_字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        int start=0;
        int end=0;
        HashMap<Integer,Integer> leftIndexMap=new HashMap<>();//key：前缀和，value：和为key的最左索引
        leftIndexMap.put(0, -1); //初始化
        int preSum=0;
        for (int i = 0; i < array.length; i++) {
            preSum += Character.isDigit(array[i].charAt(0)) ? 1 : -1; //字母象征着-1，数字象征着1
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
        return Arrays.copyOfRange(array, start + 1, end + 1);
    }
}
