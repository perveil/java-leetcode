package stack;/*
  @Date:2020/9/29 9:38
  @Author:Administrator
*/

import java.util.*;

public class leetcode150_逆波特兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        int res=0;
        Stack<Integer> numberStack=new Stack<>(); //数字栈
        for (String token:
             tokens) {
            try{
                int num=Integer.parseInt(token);
                numberStack.push(num);
            }catch (Exception e){ // catch 到符号
                int num2=numberStack.pop();
                int num1=numberStack.pop();
                switch (token.charAt(0)){ //switch 选择计算方式
                    case '+':
                        res=num1+num2;
                         break;
                    case '-':
                        res=num1-num2;
                        break;
                    case '/':
                        res=num1/num2;
                        break;
                    case '*':
                        res=num1*num2;
                        break;
                    default:break;
                }
                numberStack.push(res);
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode150_逆波特兰表达式求值().evalRPN(new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        });
    }
}
