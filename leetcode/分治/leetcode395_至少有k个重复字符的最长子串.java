package 分治;/*
  @Date:2021/1/7 23:16
  @Author:Administrator
*/

import java.util.*;

public class leetcode395_至少有k个重复字符的最长子串 {
    String s;
    int k;
    public int longestSubstring(String s, int k) {
        this.k=k;
        this.s=s;
        return helper(0,s.length()-1);
    }
    public int helper(int l, int r) {
        if (r-l+1<k) return 0;
        int [] time=new int[26];
        for (int i = l; i <=r ; i++) {
            time[s.charAt(i)-'a']++;
        }
        int ll=l;
        int rr=r;
        //排除两侧不满足条件的字符
        while(ll <= rr && time[s.charAt(ll)-'a'] < k) {
            ll++;
        }
        while (ll <= rr &&  time[s.charAt(rr)-'a'] < k) {
            rr--;
        }
        if (rr - ll + 1 < k) return 0;
        //找到字符串中间的不满足k的字符
        int partition = ll;
        while (partition <= rr && time[s.charAt(partition)-'a'] >= k) {
            partition++;
        }
        if (partition<rr) {
            return Math.max(helper(ll, partition-1), helper(partition+1, rr));
        }
        return rr-ll+1;
    }
}
