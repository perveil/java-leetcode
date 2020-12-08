package traceBack;/*
  @Date:2020/12/8 10:39
  @Author:Administrator
*/

import java.util.*;

public class leetcode842_将数组拆分成斐波那契额数列 {
    //Map<Integer>
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res=new LinkedList<>();
        helper(0,res,S);
        return  res;
    }
    public boolean helper(int startindex, List<Integer> res,String S) {
        if (startindex==S.length()){ //递归结束条件
            return res.size()>2;
        }
        for (int i = startindex+1; i <=S.length(); i++) {
            String temp=S.substring(startindex,i);
            //长度大于10,或者Long解析出来大于INT_MAX了就直接break
            if (S.charAt(startindex) == '0' && i>startindex+1 || temp.length()>10 || Long.valueOf(temp)>Integer.MAX_VALUE) {
                break;
            }
            Integer i1=res.size()>2?res.get(res.size()-2):-1;
            Integer i2=res.size()>2?res.get(res.size()-1):-1;
            int num=Integer.valueOf(temp);
            res.add(num);
            if ((i1==-1 || i2==-1 || i1+i2==num) && helper(i,res,S)) {
                return true;
            }
            res.remove(res.size()-1);
        }
        return false;
    }

    public static void main(String[] args) {
        new leetcode842_将数组拆分成斐波那契额数列().splitIntoFibonacci("123456579");
    }
}
