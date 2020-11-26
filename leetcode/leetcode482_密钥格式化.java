import java.util.*;

public class leetcode482_密钥格式化 {
    /*
    *  StringBuilder 的insertAPI
   public String licenseKeyFormatting(String S, int K) {
       if (K <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < S.length();i++) {
            if (S.charAt(i) != '-') {
                builder.append(S.charAt(i));
            }
        }

        for (int i = builder.length() - K;i > 0;i -= K) {
            builder.insert(i,'-');
        }

        return builder.toString().toUpperCase();
    }
    * */
    public String licenseKeyFormatting(String S, int K) {
        String res="";
        String cur="";
        String [] passwords=S.split("-");
        int len =passwords.length;
        for (int i =len-1; i >-1 ; ) {
            cur=passwords[i].toUpperCase()+cur;
            if (cur.length()==K){
                res='-'+cur+res;
                cur=""; //置空
                i--;
                continue;
            }
            if (cur.length()>K){
                res='-'+cur.substring(cur.length()-K)+res;
                passwords[i]=cur.substring(0,cur.length()-K);
                cur=""; //置空
                continue;
            }
            i--;
        }
        if (cur.length()>0){
            if (cur.length()<=K) res='-'+cur+res;
            if (cur.length()>K) {
                res='-'+cur.substring(cur.length()-K)+res;
                res='-'+cur.substring(0,cur.length()-K)+res;
            }
        }
        return res.substring(1);
    }


    public static void main(String[] args) {
        new leetcode482_密钥格式化().licenseKeyFormatting("2-5g",1);
    }
}
