import java.util.*;

public class leetcode1304_和为零的N个唯一整数 {
    public int[] sumZero(int n) {
        if (n==1) return  new int[]{0};
        int[] nums=new int[n];
        //n为奇数
        if (n%2==1){
            int mid =(n-1)/2;
            nums[mid]=1;
            int start=0;
            int end=n-1;
            int num=4;
            nums[start++]=-3;
            nums[end--]=2;
            while(start<end){
                nums[start++]=num;
                nums[end--]=-num;
                num++;
            }
        }else{  //n为偶数
            int start=0;
            int end=n-1;
            int num=1;
            while(start<end){
                nums[start++]=num;
                nums[end--]=-num;
                num++;
            }
        }
        return nums;
    }
}
