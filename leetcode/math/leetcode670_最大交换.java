package math;/*
  @Date:2021/1/8 21:17
  @Author:Administrator
*/

import java.util.*;

public class leetcode670_最大交换 {
    public int maximumSwap(int num) {
        if (num<10) return num;
        char [] chars=Integer.toString(num).toCharArray();
        int len=chars.length;
        int[] maxIndex=new int[len];
        int maxindex=len-1;
        maxIndex[len-1]=maxindex;
        for (int i = len-2; i >-1; i--) {
            if (chars[i]-'0'>chars[maxindex]-'0'){
                maxindex=i;
            }
            maxIndex[i]=maxindex;
        }
        for (int i = 0; i <len; i++) {
            if (chars[i]-'0' <chars[maxIndex[i]]-'0'){
                char temp=chars[i];
                chars[i]=chars[maxIndex[i]];
                chars[maxIndex[i]]=temp;
                break;
            }
        }
        return Integer.valueOf(new String(chars));
    }

    public static void main(String[] args) {
        new leetcode670_最大交换().maximumSwap(99999373);
    }
}
