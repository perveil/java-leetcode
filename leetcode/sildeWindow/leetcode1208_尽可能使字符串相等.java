package sildeWindow;/*
  @Date:2020/12/24 14:43
  @Author:Administrator
*/

import java.util.*;

public class leetcode1208_尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len=s.length();
        int [] gaps=new int[len];
        for(int i=0;i<len;i++){
            gaps[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int l=0;
        int r=0;
        int res=0;
        int cur=0;
        while(r<len){
            cur+=gaps[r];
            while(l<=r&&cur>maxCost){
                cur-=gaps[l];
                l++;
            }
            res=Math.max(r-l+1,res);
            r++;
        }
        return res;

    }

    public static void main(String[] args) {
        new leetcode1208_尽可能使字符串相等().equalSubstring("abcd","cdef",1);
    }
}
