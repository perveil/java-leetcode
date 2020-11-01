package stack;

import java.util.*;

public class leetcode1021_删除最外层的括号 {
    public String removeOuterParentheses(String S) {
        StringBuilder res=new StringBuilder();
        char[] chars=S.toCharArray();
        Stack<Character> stack=new Stack<>();
        List<String> strs=new ArrayList<>();
        int start=0;
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]==')'){
                stack.pop();
                if (stack.size()==0){
                    res.append(S.substring(start+1,i));
                    start=i+1;
                    continue;
                }
            }else { //chars[i]=='('
                stack.push(chars[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        new leetcode1021_删除最外层的括号().removeOuterParentheses("(()())(())(()(()))");
    }
}
