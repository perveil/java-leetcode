package sildeWindow;/*
  @Date:2021/1/8 20:39
  @Author:Administrator
*/

import java.util.*;

public class leetcode3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int res=-1;
        int len =s.length();
        int left=0;
        int right=0;
        int times[]=new int[26];
        while(right<len){
            int index=s.charAt(right)-'a';
            int newCount=++times[index];

            while(left<=right && newCount>1){
                times[s.charAt(left)-'a']--;
                if (s.charAt(left)-'a'==index) newCount--;
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode3_无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb");
    }
}
