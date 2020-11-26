import java.util.*;

public class leetcode1370_上升下降字符串 {
    Map<Character,Integer> map=new TreeMap<>();
    int size;
    public String sortString(String s) {
        StringBuilder res=new StringBuilder();
        size=s.length();
        for (char ch:s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        while(size>0){
            // 步骤1，2，3
            // 步骤4，5，6
            res.append(step()).append(step().reverse());
        }
        return res.toString();
    }
    public StringBuilder step(){
        StringBuilder res=new StringBuilder();
        for (char ch:map.keySet()) {
            if (map.get(ch)==0){
                continue;
            }
            res.append(ch);
            map.put(ch,map.get(ch)-1);
            size--;
        }
        return res;
    }
    public static void main(String[] args) {
         new leetcode1370_上升下降字符串().sortString("spo");
    }
}
