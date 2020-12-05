package 前缀和;
/*
  @Date:2020/12/4 16:14
  @Author:Administrator
*/
import java.util.*;

public class leetcode974_和可倍K整除的子数组 {
    /*
    我们令 P[i] = A[0] + A[1] + ... + A[i]。那么每个连续子数组的和 sum(i,j) 就可以写成 P[j] - P[i-1]（其中 0 < i < j）的形式。
    此时，判断子数组的和能否被 K 整除就等价于判断 (P[j] - P[i-1]) % K == 0，根据 同余定理，只要 P[j]% K == P[i-1] % K，就可以保证上面的等式成立。
    * */
    public int subarraysDivByK(int[] A, int K) {
        //求前缀和
        int len=A.length;
        int sum=0;
        for (int i = 0; i <len; i++) {
            sum+=A[i];
        }
        int res=0;
        Map<Integer,Integer> map=new HashMap<>(); //和为Key的子数组的个数
        sum=0;
        map.put(0,1); //前缀和本身被K 整除的情况
        for (int i = 0; i <len ; i++) { //从前向后遍
            sum+=A[i];
            int rest=(sum%K+K)%K; //负数 -1%2=-1  需要做处理 (-1%2+2)%2 将负数对k的模转化为正数，并不是取反的意思，比如 -2%6!=-2而是 4
            res+=map.getOrDefault(rest,0);
            map.put(rest,map.getOrDefault(rest,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode974_和可倍K整除的子数组().subarraysDivByK(new int[]{
                2,-2,2,-4
        },6);
        System.out.println(
                -16%5
        );
    }
}
