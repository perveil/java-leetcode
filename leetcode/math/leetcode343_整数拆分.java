package math;/*
  @Date:2020/12/8 22:35
  @Author:Administrator
*/

import java.util.*;

public class leetcode343_整数拆分 {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int mod=n%3;
        if(mod==1){
            return (int)Math.pow(3,n/3-1)*4;
        }
        if(mod==2){
            return (int)Math.pow(3,n/3)*2;
        }
        return (int)Math.pow(3,n/3);
    }

    public static void main(String[] args) {
        new leetcode343_整数拆分().integerBreak(5);
    }
}
