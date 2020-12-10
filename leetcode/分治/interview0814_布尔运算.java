package 分治;/*
  @Date:2020/12/10 10:14
  @Author:Administrator
*/

import java.util.*;
// 与leetcode 241 类似,修改运算符即可
public class interview0814_布尔运算 {
    Map<String,List<Integer>> map=new HashMap<>();
    public int countEval(String s, int result) {
        List<Integer> res=diffWaysToCompute(s);
        int resnum=0;
        for (Integer i:res) {
            if (i==result){
                resnum++;
            }
        }
        return  resnum;
    }
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> list=new ArrayList<>();
        int len=input.length();
        for (int i = 0; i <len ; i++) {
            char c=input.charAt(i);
            if(c == '&' || c == '|' || c == '^') {
                //分治
                List<Integer> left=diffWaysToCompute(input.substring(0,i)); //不带运算符
                List<Integer> right=diffWaysToCompute(input.substring(i+1,len));
                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '&':
                                list.add(l & r);
                                break;
                            case '|':
                                list.add(l | r);
                                break;
                            case '^':
                                list.add(l ^ r);
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
