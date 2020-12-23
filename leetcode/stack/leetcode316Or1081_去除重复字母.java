package stack;/*
  @Date:2020/12/2 9:59
  @Author:Administrator
*/

import java.util.*;
/*
*  字典序 ：1 2 3 4 5 的最小字典序：12345 最大字典序为54321
*
* 相同类型题：402 321
* */
public class leetcode316Or1081_去除重复字母 {
    public String smallestSubsequence(String s) {
        int chars[] =new int[26]; //没遍历过的字符的个数
        for(char c:s.toCharArray()){
            chars[c-'a']++;
        }
        Stack<Integer> stack=new Stack<>();
        for (Character c:s.toCharArray()) { //单调递增栈,保证字典序最小
            int index=c-'a';
            if (stack.indexOf(index)==-1){   //栈上没有这个元素,该元素一定会进栈,如果有就直接跳过
                while(!stack.isEmpty() &&stack.peek()>(index)  &&chars[stack.peek()]>0){   //栈顶出现了逆序的元素且，chars[stack.peek()]>0 如果这个数以后还有被访问的机会，就可以pop()
                    stack.pop();           //大的数被pop
                }
                stack.push(index);
            }
            chars[index]--; //遍历过的元素个数--，保证栈中的元素最后都只出现一次
        }
        StringBuilder res=new StringBuilder();
        while (!stack.isEmpty()) {
            res.append((char) (stack.pop() + 'a'));
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        new leetcode316Or1081_去除重复字母().smallestSubsequence("cbacdcbc");
    }
}