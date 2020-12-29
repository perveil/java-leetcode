package sildeWindow;/*
  @Date:2020/12/29 9:17
  @Author:Administrator
*/

import java.util.*;

public class leetcode1456_定长子串中元音的最大数目 {
    public int maxVowels(String s, int k) {
        int res=-1;
        int l=0;
        int r=0; //r-l+1 = 窗口大小
        int len=s.length();
        int cur=0;
        while(r<len){
            cur+=isVowels(s,r)?1:0;
            while(l<=r&&(r-l+1)>k){
                cur-=isVowels(s,l)?1:0;
                l++;
            }
            res=Math.max(cur,res);
            r++;
        }
        return res==-1?0:res;
    }
    public boolean isVowels(String s, int k) {
        return s.charAt(k)=='a' ||s.charAt(k)=='e' ||s.charAt(k)=='i'||s.charAt(k)=='o'||s.charAt(k)=='u';
    }

    public static void main(String[] args) {
        new leetcode1456_定长子串中元音的最大数目().maxVowels("rhythms",3);
    }
}
