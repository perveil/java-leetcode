import java.util.*;

public class leetcode462_最少移动次数使数组元素相等II {
    //求数组的中位数
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int mid=(int) Math.ceil(len/2);
        return len%2==0?Math.max(helper(nums,mid),helper(nums,mid-1)):helper(nums,mid);

    }
    public int helper(int[] nums,int mid) {
        int sum=0;
        for (int i = 0; i <nums.length; i++) {
            if (i==mid) continue;
            if (i<mid) sum+=nums[mid]-nums[i];
            if (i>mid) sum+=nums[i]-nums[mid];
        }

        return  sum;
    }

    public static void main(String[] args) {
        new leetcode462_最少移动次数使数组元素相等II().minMoves2(new int[]{1,2,7,8});
    }
}
