

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class leetcode290_单词规律 {
    /*
    * leetcode 205 同解法
    * */
    public boolean wordPattern1(String pattern, String str) {
        String patternToNum=StringTonums(pattern,"");
        String strTonum=StringTonums(str," ");
        return strTonum.equals(patternToNum);
    }
    public String StringTonums(String str,String re) {
        String [] strings=str.split(re);
        StringBuilder res=new StringBuilder();
        int num=1;
        HashMap<String,Integer> map=new HashMap<>();
        for (String s:
             strings) {
            if (!map.containsKey(s)){
                map.put(s,num);
                num++;
            }
        }
        for (String s:strings){
            res.append(map.get(s));
        }
        return res.toString();
    }

    //简单解法
    public boolean wordPattern(String pattern, String str) {
        String [] strs=str.split(" ");
        HashMap<Character,String> map=new HashMap<>();
        Set<String> set = new HashSet<>();
        if (strs.length!=pattern.length()) return false;
        for (int i = 0; i <pattern.length(); i++) {
            char c=pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(strs[i])){
                    return false;
                }
            }else { //如果没有，就需要建立一一对应的关系
                if (set.contains(strs[i])){ //如果strs[i]之前已经建立了关系，则建立失败
                    return false;
                }
                set.add(strs[i]);
                map.put(c,strs[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode290_单词规律().wordPattern("abba","dog cat cat fish");
    }
}
