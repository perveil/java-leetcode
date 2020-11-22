import java.util.*;

public class leetcode396_旋转函数 {
    //暴力法
    public int maxRotateFunction(int[] A) {
        if (A.length==0) return 0;
        int len=A.length;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <len ; i++) {
            int sum=0;
            for (int j = 0; j <len; j++) {
                sum+=A[j]*((j+i)%len);
            }
            max=Math.max(max,sum);
        }
        return  max;
    }
    //数学推导法

    public static void main(String[] args) {
        new leetcode396_旋转函数().maxRotateFunction(new int[]{4, 3, 2, 6});
    }
}
