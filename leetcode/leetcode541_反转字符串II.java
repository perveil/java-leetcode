import java.util.*;

public class leetcode541_反转字符串II {
    public String reverseStr(String s, int k) {
        StringBuilder res=new StringBuilder();
        while(s.length()>k){
            int len=s.length();
            String temp=new StringBuilder(s.substring(0,k)).reverse().toString(); //旋转的前k个
            String temp2="";
            if (s.length()>=2*k){
                temp2=s.substring(k,2*k);
                s=s.substring(2*k,len); //删除已经拼接完的
            }else {
                temp2=s.substring(k,len);
                s=""; //结束
            }
            res.append(temp).append(temp2);
        }
        if (s.length()>0) res.append(new StringBuilder(s).reverse()); //拼接最后一部分

        return  res.toString();
    }

    public static void main(String[] args) {
        new leetcode541_反转字符串II().reverseStr("abcdefg",2);
    }
}
