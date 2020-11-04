import java.util.*;

public class leetcode1588_所有奇数长度子数组的和 {
    //暴力解法
    public int sumOddLengthSubarrays1(int[] arr) {
        if (arr.length<1) return 0;
        int sum=0;
        for (int i = 1; i <= arr.length; i+=2) {
            for (int start = 0; start<arr.length; start++) {
                if (start+i>=arr.length) break;
                sum+=sum(arr,start,start+i);
            }
        }
        return sum;
    }
    public int sum(int[] arr,int start,int end) {
        int sum=0;
        for (int i = start; i <end ; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    //O(n) 解法
    /*
    *  算法原理：查看这个元素会在多少个长度为奇数的数组中出现过。
    *  比如题目给出的第一个测试用例 [1, 4, 2, 5, 3] 中；
        1 在 3 个长度为奇数的数组中出现过：[1], [1, 4, 2], [1, 4, 2, 5, 3]；所以最终的和，要加上 1 * 3；

        4 在 4 个长度为奇数的数组中出现过：[4], [4, 2, 5], [1, 4, 2], [1, 4, 2, 5, 3]；所以最终和，要加上 4 * 4；
    *  对于一个数字(索引 i)，它所在的数组，可以从它前面0....(i-1),共有i-1-0+1=i个选择，后边有（i+1）....(n-1),长度为n-1-(i+1)+1=n-i-1,n是数组长度
    *   如果在前面选择了偶数个数字，那么在后面，也必须选择偶数个数字，这样加上它自身，才构成奇数长度的数组
    *   如果在前面选择了奇数个数字，那么在后面，也必须选择奇数个数字，这样加上它自身，才构成奇数长度的数组
    *   数字前面共有i个选择，其中偶数个数字的选择方案为：left_even=(i+1)/2,left_odd=i/2
    *   数字后面共有n-i-1个选择，其中偶数个数字的选择方案为：right_even=(n-i)/2,right_odd=n-i-1/2
    * */
    public int sumOddLengthSubarrays(int[] arr){
        int res = 0;
        for(int i = 0; i < arr.length; i ++){
            /*
            * 但是为什么left=i+1 而不是i,right=arr.length-i 而不是  arr.length-i-1
            * 涉及小数点取整的问题
            * */
            int left = i+1, right = arr.length - i,
                    left_even = (left + 1) / 2, right_even = (right + 1) / 2,
                    left_odd = left / 2, right_odd = right / 2;
            res += (left_even * right_even + left_odd * right_odd) * arr[i];
        }
        return res;

    }
    public static void main(String[] args) {
         new leetcode1588_所有奇数长度子数组的和().sumOddLengthSubarrays(new int[]{1,4,2,5,3});
    }
}
