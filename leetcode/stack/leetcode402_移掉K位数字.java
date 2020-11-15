package stack;/*
  @Date:2020/11/15 10:14
  @Author:Administrator
*/

import java.util.*;

public class leetcode402_移掉K位数字 {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){ //移除所有的数字，剩余为空就是0
            return "0";
        }
        Stack<Integer> stack=new Stack<>();
        for (Character c:num.toCharArray()) { //单调递增栈，查找大于某数的右边第一个数
            while(!stack.isEmpty() &&stack.peek()>(c-'0') && k>0){
                stack.pop(); //大的数被pop
                k--;
            }
            stack.push(c-'0');
        }
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }
        StringBuilder res=new StringBuilder();

        while (!stack.isEmpty()) {
            res.append((char) (stack.pop() + '0'));
        }
        return helper(res.reverse().toString());
    }
    //去除结果的前导0
    public String helper(String num) {
        int i=0;
        for (Character c: num.toCharArray()) {
            if (c=='0'){
                i++;
            }else {
                break;
            }
        }
        if (i==num.length()) return "0";
        return num.substring(i);
    }

    public static void main(String[] args) {
        new leetcode402_移掉K位数字().removeKdigits("112",1);
    }
}
