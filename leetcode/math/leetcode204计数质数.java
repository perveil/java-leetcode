package math;/*
  @Date:2020/12/3 9:56
  @Author:Administrator
*/

import java.util.*;

public class leetcode204计数质数 {
    /*
    * 厄尔多塞筛法求n以内质数的数量
    * 0,1 不是质数，2是质数，所有n以内的2的倍数都不是质数，3是质数，所有n以内的3的倍数都不是质数
    * 下一个是5，所有n以内的5的倍数都不是质数
    * */
    public int countPrimes(int n) {
        if(n<3){
            return 0;
        }
        int [] status=new int[n+1];
        Arrays.fill(status,1);
        status[0]=0;
        status[1]=0;
        for (int i = 2; i <(int)Math.sqrt(n)+1; i++) { //为什么i只遍历到 (int)Math.sqrt(n)+1： 如何验证一个数是质数的方法
            if (status[i]==1){
                for (int j = i; i*j <n ; j++) {
                    // j为什么从i开始
                    /*
                      n=16 为例
                    *  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
            遍历到2     0 0 1 1 0 1 0 1 0 1 0  1  0  0  0  1
            遍历到3     0 0 1 1 0 1 0 1 0 0 0  1  0  0  0  0
            遍历到5     0 0 1 1 0 1 0 1 0 0 0  1  0  0  0  0
            因为5*2（10）  5*3（15）  已经在遍历质数 2 3 的时候已经访问过了，所以不需要重复访问
                    * */
                    status[i*j]=0;
                }
            }
        }
        int res=0;
        for (int i:status){
            res+=i;
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode204计数质数().countPrimes(50);
    }
}
