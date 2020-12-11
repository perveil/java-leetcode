package graph.dfs;/*
  @Date:2020/11/11 9:47
  @Author:Administrator
*/

import java.util.*;

public class leetcode514_自由之路 {
    /*
    * 顺序处理key的每一个字符时，都会有顺时针、逆时针的选择，而且在ring 字符串中某一字符出现的次数、位置都是多个的
    * */
    Map<Character,List<Integer>> map=new HashMap<>();
    Map<Integer,Integer> memo=new HashMap<>(); //key,value 表示从key[key....key.length]所需最少的次数
    public int findRotateSteps(String ring, String key) {
        int len=key.length();
        char[] ri=ring.toCharArray();
        for (int i = 0; i <ri.length; i++) {
            if (!map.containsKey(ri[i])){
                map.put(ri[i],new ArrayList<>());
            }
            map.get(ri[i]).add(i);
        }
        return  dfs(ring,key,0,0)+len;
    }
    /*
    * curPoint :当前12点所指向的字符在ring的位置
    * curIndex :当前在处理的key的索引
    * */
    public int dfs(String ring, String key,int curIndex,int curPoint) {
        if (curIndex==key.length()){ //结束
            return 0;
        }
        if (memo.containsKey(curIndex)){ //已经有了结果
            return  memo.get(curIndex);
        }
        char ch=key.charAt(curIndex); //当前需要拼写的key中的字符
        int res=Integer.MAX_VALUE;
        for (int i:map.get(ch)) {
            int reverse=Math.abs(curPoint-i);
            int noreverse=ring.length()-reverse;
            res=Math.min(res,Math.min(noreverse,reverse)+dfs(ring,key,curIndex+1,i));
        }
        memo.put(curIndex,res);
        return  res;
    }
}
