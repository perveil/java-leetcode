package traceBack;/*
  @Date:2021/1/8 20:02
  @Author:Administrator
*/

import java.util.*;

public class leetcode1400_构造K个回文字符串 {
    public boolean canConstruct(String s, int k) {
        if (s.length()<k) return false;
        if (s.length()==k) return true;
        int [] times=new int[26];
        for (char ch:s.toCharArray()) {
            times[ch-'a']++;
        }
        int odd=0;
        for (int time:times) {
            if (time==0) continue;
            if (time%2==1){
                odd++;
            }
        }
        if (odd>k) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(

        );
        new leetcode1400_构造K个回文字符串().canConstruct("annabelle",2);
    }

}
