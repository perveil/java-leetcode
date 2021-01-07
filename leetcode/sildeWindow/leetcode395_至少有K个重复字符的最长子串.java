package sildeWindow;/*
  @Date:2021/1/7 22:56
  @Author:Administrator
*/

import java.util.*;

public class leetcode395_至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int record[]=new int[26];     //记录滑动窗口内每个字符出现的次数，字符'a'对应位置0，'b'对应位置1...
        for(int i=1; i<=26; ++i) {      //每个循环中，滑动窗口内只能有i个不同字符
            Arrays.fill(record,0);
            int left = 0, right = 0;
            int diff_count = 0, count = 0;      //分别代表滑动窗口中不同的字符数、出现次数大于等于k的字符数
            while(right < s.length()) {
                //向右扩大窗口，即把字符s[right]加入窗口
                int add_index =s.charAt(right) - 'a';     //字符s[right]（将要加入窗口的字符）在record中对应的位置
                record[add_index] += 1;
                if(record[add_index] == 1)
                    diff_count++;
                if(record[add_index] == k)
                    count++;
                right++;
                //窗口内只能包含i个不同字符，如果超过了就缩减窗口，即把字符s[left]移出窗口
                while(left < right && diff_count > i) {
                    int del_index = s.charAt(left) - 'a';  //字符s[left]（将要删除的字符）在record中对应的位置
                    if(record[del_index] == k)
                        count--;
                    if(record[del_index] == 1)
                        diff_count--;
                    record[del_index] -= 1;
                    left++;
                }
                //如果窗口内的不同字符数 == 出现次数大于等于k的字符数 == 当前循环限制的不同字符数
                if(diff_count == i && diff_count == count)
                    //说明窗口内的每个字符出现次数都大于等于k，此时的窗口是一个可行解
                    res = Math.max(res, right - left);
            }
        }
        return res;
    }
}
