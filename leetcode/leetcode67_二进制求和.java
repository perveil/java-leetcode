import java.util.*;

public class leetcode67_二进制求和 {
    public String addBinary(String a, String b) {
        if (a.length()==0) return b;
        if (b.length()==0) return a;
        //交换，字符串长的为a，短的为b；
        if(a.length()<b.length()){
            String c=a;
            a=b;
            b=c;
        }
        int d=0; // 进位
        StringBuilder res=new StringBuilder();
        int i = b.length()-1,j=a.length()-1;
        for (; i>=0 ; i--,j--) {
            int e=(b.charAt(i)-'0')+(a.charAt(j)-'0')+d;
            if (e>1){
                d=1;
                res.append(e-2);
            }else {
                d=0;
                res.append(e);
            }
        }
        while (j>=0){
            int f=(a.charAt(j)-'0')+d;
            if (f>1){
                d=1;
                res.append(f-2);
            }else {
                d=0;
                res.append(f);
            }
            j--;
        }
        if (d==1){
            res.append("1");
        }
        return  res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(
          new leetcode67_二进制求和().addBinary("1111","1111")
        );
    }
}
