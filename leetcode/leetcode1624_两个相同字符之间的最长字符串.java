import java.util.*;

public class leetcode1624_两个相同字符之间的最长字符串 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res=-1;
        Map<Character,ArrayList<Integer>> ch2List=new HashMap<>();
        char [] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(ch2List.containsKey(chars[i])){
                int size=ch2List.get(chars[i]).size();
                if(size>=1){
                    res=Math.max(res,i-ch2List.get(chars[i]).get(size-1)-1);
                }
            }else{
                ch2List.put(chars[i],new ArrayList<Integer>());
            }
            ch2List.get(chars[i]).add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1624_两个相同字符之间的最长字符串().maxLengthBetweenEqualCharacters("aa");
    }
}
