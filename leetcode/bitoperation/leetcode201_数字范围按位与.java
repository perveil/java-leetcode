package bitoperation;
/*
  @Date:2020/12/11 14:49
  @Author:Administrator
*/

import java.util.*;

public class leetcode201_数字范围按位与 {
    public int rangeBitwiseAnd(int m, int n) {
        int offset=0;
        // 假设m的二进制表达从左往右数第一个1，那么这个1往左的所有二进制数都是0，而按位取与就是有0不管有多少1都是0
        // 当一个数+1时，总会有这么一个规律“某一位后的数字，全部被置为相反数”。举个例子：010111 + 1 = 011000，则010111 & 011000 = 010000。那么，x & (x+1) 后几位相反数的“与操作”，结果总为0。
        //所以，当(m,m+1,...n-1,n)进行连续“与操作”时，会按照上述规律被抵消很大一部分
        //答案就是m和n的相同部分
        for (; m!=n; offset++) {
            m>>=1;
            n>>=1;
        }
        return m<<offset;
    }
}
