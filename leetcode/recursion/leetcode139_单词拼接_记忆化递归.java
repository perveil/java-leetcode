package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode139_单词拼接_记忆化递归 {
     /*
     * 若干个wordDict 中所有的单词 是否可以拼接成s
     * */
     HashMap<Integer,Boolean> map = new HashMap<>(); //Integer i,boolean true 指的是从i开始之后的字符串是否可以由wordDict 组成
     List<Integer> word_len;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.word_len=new ArrayList<>();
        for (String w: wordDict) {
            word_len.add(w.length());
        }
        return getResult(s,0,wordDict);

    }
    private boolean getResult(String s, int start,List<String> wordDict) {
        if (start==s.length()){
            return true;
        }
        if (map.containsKey(start)){
            return map.get(start);
        }
        /*
        * 遍历所有的单词长度
        * */
        for (int len: word_len) {
            if (start+len>s.length()) continue;
            if (wordDict.contains(s.substring(start,start+len))){
                if (getResult(s,start+len,wordDict)){
                    map.put(start,true);
                    return true;
                }
            }
        }
        map.put(start,false); //回溯
        return false;
    }


}
