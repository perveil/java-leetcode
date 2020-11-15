package stack;

import java.util.*;

public class leetcode1106_解析布尔表达式 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch==')'){ //遍历到），则计算一次，从内到外的计算（）
                int count_t=0,count_f=0;
                char p = s.pop();
                while(p!='('){ // 找到（ 的时候，此时stack栈顶的元素就是运算符
                    if(p=='t') count_t++;
                    if(p=='f') count_f++;
                    p = s.pop();
                }
                char op = s.pop();
                if(op=='!'){  // 非运算中，运算式只有一个，或者t或者f !(expr)
                    s.add(count_t==0?'t':'f');
                }else if(op=='|'){ // 或运算看 t的个数
                    s.add(count_t==0?'f':'t');  // |(expr1,expr2,...)
                }else if(op=='&'){//与运算得看f的个数 &(expr1,expr2,...)
                    s.add(count_f==0?'t':'f');
                }
            }
            else if(ch!=',') s.add(ch);
        }
        return s.pop()=='t'?true:false;
    }

    public static void main(String[] args) {
        new leetcode1106_解析布尔表达式().parseBoolExpr("|(&(t,f,t),!(t))");
    }
}
