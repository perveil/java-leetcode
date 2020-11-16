package sildeWindow;
/*
  @Date:2020/11/16 10:11
  @Author:Administrator
*/

import java.util.*;

public class leetcode1052_爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len=customers.length;
        int sum[]=new int[len]; //条件前缀和,sum[i] 表示0...i中满意的最大客户数量
        int res=Integer.MIN_VALUE;
        sum[0]=grumpy[0]==0?customers[0]:0;
        int presum=sum[0];
        for (int i = 1; i <len ; i++) {
            sum[i]=presum+(grumpy[i]==0?customers[i]:0);
            presum=sum[i];
        }
        for (int left=0;left<=len-X;left++){ //left 为窗口左边界，right 为窗口右边界
            int right=left+X;
            int sumWindow=0;
            for (int i = left; i<right ; i++) { //窗口内的所有数值都加上
                sumWindow+=customers[i];
            }
            //窗口左侧
            int windowLeft=left-1<0?0:sum[left-1];
            //窗口右侧
            int windowRight=sum[len-1]-sum[right-1];
            res=Math.max(res,windowLeft+windowRight+sumWindow);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1052_爱生气的书店老板().maxSatisfied(new int[]{
                1,0,1,2,1,1,7,5
        },new int[]{
                0,1,0,1,0,1,0,1
        },2);
    }
}
