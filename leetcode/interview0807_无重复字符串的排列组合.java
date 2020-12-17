import java.util.*;

public class interview0807_无重复字符串的排列组合 {
    List<String> res=new ArrayList<>();
    public String[] permutation(String S) {
        helper(S,"");
        int i=0;
        String[] res1=new String[res.size()];
        for (String s:res) {
            res1[i++]=s;
        }
        return res1;
    }
    public void helper(String S,String cur) {
        if (S.length()==0){
            res.add(cur);
            return;
        }
        for (int i = 0; i <S.length(); i++) {
            String newStr=S.substring(0,i)+S.substring(i+1); //去除S[i];
            helper(newStr,cur+S.charAt(i));
        }
    }

    public static void main(String[] args) {
        for (String s: new interview0807_无重复字符串的排列组合().permutation("qweb")
             ) {
            System.out.println(s);
        }
    }
}
