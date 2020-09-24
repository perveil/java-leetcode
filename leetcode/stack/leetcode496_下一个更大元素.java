package stack;/*
  @Date:2020/9/24 10:52
  @Author:Administrator
*/

import java.util.*;

public class leetcode496_下一个更大元素 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        int resi=0;
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer>  map=new HashMap<>();
        for (Integer num:nums2) { //单调递减栈，查找大于某数的右边第一个数
            while(!stack.isEmpty() &&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i = 0; i <nums1.length ; i++) {
            res[i]=map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
