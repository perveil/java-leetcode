package sildeWindow;/*
  @Date:2020/11/24 14:34
  @Author:Administrator
*/

import java.util.*;

public class leetcode1004_最大连续1的个数III {
    //窗口内0的个数维持到3个以下，包括3个
    public int longestOnes(int[] A, int K) {
       // if (K==0) return 0;
        int left=0;
        int right=0;
        int len=A.length;
        int curWindow=0;  //当前窗口内0的个数为
        int res=-1;
        while(right<len){
            if (A[right]==0)
                curWindow++;
            while(curWindow>K &&left<=right){
                if (A[left]==0) curWindow--;
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1004_最大连续1的个数III().longestOnes(new int[]{0,0,0,0},0);
    }
}
