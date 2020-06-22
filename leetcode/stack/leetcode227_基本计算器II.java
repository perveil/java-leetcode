package leetcode.stack;
/*
  @Date:2020/4/28 9:17
  @Author:Administrator
*/

import java.util.*;

public class leetcode227_基本计算器II {
    public int calculate(String s) {
        Stack<Integer> numStack=new Stack<>();
        //符号、数字入栈
        int num=0;
        char sign='+'; //初试符号
        for (int i=0;i<s.length();) {
            char c=s.charAt(i);
            if ('0' <= c && c <= '9'){
                num=num*10+(c-'0'); //整数
            }
            if (!('0' <= c && c <= '9') || i==s.length()-1){ //当遍历到一个符号时，计算上一个符号sign所得出的结果
                if (c==' '){ //忽略空格
                    continue;
                }
                //找到括号，递归计算
                if (c=='('){
                    int rightIndex=s.indexOf(')',i); //找到)
                    num=calculate(s.substring(i+1,rightIndex));
                    numStack.push(num);
                    i+=(rightIndex-i+1);
                    continue;
                }
                int pre=0;
                switch (sign){
                    case '+':
                        numStack.push(num); break;
                    case '-':
                        numStack.push(-num); break;
                    // 只要拿出前一个数字做对应运算即可
                    case '*':
                        pre = numStack.peek();
                        numStack.pop();
                        numStack.push(pre * num);
                        break;
                    case '/':
                        pre = numStack.peek();
                        numStack.pop();
                        numStack.push(pre / num);
                        break;

                }
                sign=c; //更新符号
                num=0;
                i++;
            }
        }
        int sum=0;
        while (!numStack.isEmpty()){
            sum+=numStack.pop();
        }
        return sum;
    }
    //解决括号的问题
    public static void main(String[] args) {
        new leetcode227_基本计算器II().calculate("1-1+1");
    }

}
