package dfs;/*
  @Date:2020/11/11 9:11
  @Author:Administrator
*/

import java.util.*;

public class leetcode756_金字塔转换矩阵 {
    Map<String,List<Character>> map=new HashMap<>();
    Map<String,Boolean> memo=new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String str: allowed) {
            String key=str.substring(0,2);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(key.charAt(2));
        }
        return  dfs(bottom,"");
    }
    /*
    * pre：下层
    * now：pre的上层
    * */
    public boolean dfs(String pre, String now) {
        if (pre.length()==1){
            return true;
        }
        //开始下一层
        if (now.length()+1==pre.length()){
            return  dfs(now,"");
        }
        int len=now.length();
        String key=pre.substring(len,len+2); //***
        /*
        * pre :AABA
        * now: AA->A、AB->?、BA->?
        * */
        if (!map.containsKey(key)){
            return false;
        }
        for (Character c: map.get(key)) {
            if (dfs(pre,now+c)){
                return true;
            }
        }
        return false;
    }
}
