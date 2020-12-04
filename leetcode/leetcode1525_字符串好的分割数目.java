import java.util.*;

public class leetcode1525_字符串好的分割数目 {
    public int numSplits(String s) {
        int len =s.length();
        int[] leftMap=new int[s.length()];  //从0到key索引范围内有value个不同字符
        int[] rightMap=new int[s.length()]; //从key到n-1索引范围内有value个不同字符
        Set<Character> chars=new HashSet<>(); //
        for (int i = 0; i <len ; i++) {
            chars.add(s.charAt(i));
            leftMap[i]=chars.size();
        }
        chars.clear();
        for (int i =len-1; i >=0; i--) {
            chars.add(s.charAt(i));
            rightMap[i]=chars.size();
        }
        int res=0;
        for (int i = 1; i <=len-1 ; i++) {
            if (leftMap[i-1]==rightMap[i]){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1525_字符串好的分割数目().numSplits("acbadbaada");
    }
}
/*
    //暴力
    public int numSplits(String s) {
        int len =s.length();
        int res=0;
        for (int i = 1; i <len; i++) {
            // o..i-1 为左边字符串
            // i...len-1 为右边字符串
            if (numOfdiffChar(s,0,i-1)==numOfdiffChar(s,i,len-1)){
                res++;
            }
        }
        return res;
    }
    public int numOfdiffChar(String s,int start,int end) {
        Set<Character> chars=new HashSet<>();
        for (int i = start; i <=end; i++) {
            chars.add(s.charAt(i));
        }
        return  chars.size();
    }
* */
