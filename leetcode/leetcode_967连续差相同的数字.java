import java.util.*;

public class leetcode_967连续差相同的数字 {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n==1) return  new int[]{0,1,2,3,4,5,6,7,8,9}; //n=1,答案唯一

        // n=1 的情形
        Set<Integer> cur = new HashSet();
        for (int i = 1; i <= 9; ++i)
            cur.add(i);
        //n=2.3...
        //从前向后更新
        for (int steps = 1; steps <= n-1; ++steps){ //因为已经确定了一位，所以还需要n-1位循环结束
            Set<Integer> cur2 = new HashSet();
            for (int x: cur) {
                int d = x % 10;
                if (d-k >= 0){
                    cur2.add(10*x + (d-k));
                }
                if (d+k <= 9)
                    cur2.add(10*x + (d+k));
            }
            cur=cur2; //向下递归

        }
        int[] ans = new int[cur.size()];
        int t = 0;
        for (int x: cur)
            ans[t++] = x;
       // return  ans;
        return  ans;
    }
}
