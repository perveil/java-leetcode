package stack;/*
  @Date:2020/9/22 11:38
  @Author:Administrator
*/

import java.util.*;

public class leetcode962_最大宽度坡 {
    /*
    *  step 1： 从大到小依次将元素索引加入栈，形成单调减少的栈内容
    *  step 2： 从后往前的遍历，找到第一个小于当前元素的位置
    * */
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        for (int i = n - 1; i >= res; i--) { //res是一次小优化
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i -  stack.pop());
            }
        }
        return res;
    }
}
