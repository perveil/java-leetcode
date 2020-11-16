package sildeWindow;
/*
  @Date:2020/11/16 9:12
  @Author:Administrator
*/

import java.util.*;
/*
   最简单的解法
    public boolean hasAllCodes(String s, int k) {
        int count = (int) Math.pow(2, k);
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            set.add(s.substring(i,i+k));
            if(set.size()==count) return true;
        }
        return false;
    }
*/
public class leetcode1461_检查一个字符串是否包含所有长度为K的二进制子串 {
    public boolean hasAllCodes(String s, int k) {
        if (k>s.length()) return false;
        Set<Integer> set=new HashSet<>();
        int cur=0;
        for (int i = 0; i <k-1 ; i++) { //先计算的前k-1位数字所代表的数
            cur=(2*cur)+(s.charAt(i)=='1'?1:0);
        }
        //加一位变成k，减一位变成k，利用滑动窗口的思想
        for (int i = k-1; i <s.length() ; i++) {
            cur=(2*cur)+(s.charAt(i)=='1'?1:0); //加上1位，变成k位
            set.add(cur);
            cur &= ~(1<<(k-1)); //去掉首位，变成k-1位 ~取反
        }
        return  set.size()==(1<<k);
    }
}
