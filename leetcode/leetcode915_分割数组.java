import java.util.*;

public class leetcode915_分割数组 {
    public int partitionDisjoint(int[] A) {
       int len=A.length;
       if (len<2) return 0;
       int left2right[]=new int[len];
       int right2left[]=new int[len];
       //从左到右
       int min=A[0];
       int max=A[0];
       left2right[0]=max;
       for (int i = 1; i <len; i++) {
           if (A[i]>max){ left2right[i]=A[i]; max=A[i];}
           else left2right[i]=max;
       }
       //从右到左
        min=A[len-1];
        right2left[len-1]=min;
        for (int i = len-2; i >0; i--) {
            if (A[i]<min) {right2left[i]=A[i]; min=A[i];}
            else right2left[i]=min;
        }
        for (int i = 0; i <len-1; i++) {
            if (left2right[i]<right2left[i+1]){
                //0...i 的最大值与 i+1... len的最小值相比
                return i+1;
            }
        }
       return  1;
    }

    public static void main(String[] args) {
        new leetcode915_分割数组().partitionDisjoint(new int[]{5,0,3,8,6});
    }
}
