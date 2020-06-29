package DivideAndConquer;
/*
  @Date:2020/6/29 11:00
  @Author:Administrator
*/
/*
* 分治+记忆化搜索
* */
import java.util.*;
/*
* 将问题转化为一个排列组合的问题，将一个大问题转化为一个小问题
* 2*3-4*5
*  1. 2 and 3-4*5
*  2. 2*3 and 4*5
*  3. 2*3-4 and 5
* 将一个大问题转化为具有三种可能性的多个小问题
* */
public class leetcode241_为运算表达式设计优先级 {
    List<Integer> result = new ArrayList<>();
    HashMap<String,List<Integer>> map = new HashMap<>(); //记忆化搜索的Map，key是所要计算的数学表达式，value是数学表达式的所有的可能的结果
    /*
    * return :input 所对应的所有的计算可能性
    *
    * */
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) { //递归停止条件
            return new ArrayList<>();
        }
        //记忆化第一步，查看是否计算完毕
        if(map.containsKey(input)){
            return map.get(input);
        }
        //全是数字
        int num=0;
        int index=0; //input 的遍历单位
        while(index<input.length() && !isOperation(input.charAt(index))){
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        //全是数字
        if (index == input.length()) {
            result.add(num);
            map.put(input,result);
            return result;
        }
        //不全是数字
        //根据运算符切分
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                //分治法切分
                List<Integer> result1=diffWaysToCompute(input.substring(0,i)); //向下递归
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                //将两个结果依次运算
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        char op = input.charAt(i);
                        result.add(caculate(result1.get(j), op, result2.get(k)));
                    }
                }

            }
        }
        //计算结束
        map.put(input,result);
        return result;
    }
    //single 表达式的计算
    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }
    //将大问题划分为小问题的临界位置是运算符的位置
    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
