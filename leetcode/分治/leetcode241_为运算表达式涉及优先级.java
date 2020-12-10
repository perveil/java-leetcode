package 分治;

import java.util.*;
import java.util.logging.Level;

public class leetcode241_为运算表达式涉及优先级 {
    // 碰到运算符号，递归求解前一半的值和后一半的值，然后遍历前一半和后一半的不同取值的组合
    Map<String,List<Integer>> map=new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> list=new ArrayList<>();
        int len=input.length();
        for (int i = 0; i <len ; i++) {
            char c=input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                //分治
                List<Integer> left=diffWaysToCompute(input.substring(0,i)); //不带运算符
                List<Integer> right=diffWaysToCompute(input.substring(i+1,len));
                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(input)); // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return  list;
    }
}
