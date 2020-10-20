import java.util.*;

public class leetcode363_和不超过K的子矩阵 {
    //给定一个长度为n的数组，求数组的最大子序和，这个子序和要求不能超过K且最接近K。
    /*
    * sum[i,j] 指的是的索引 i->j 的子数组的元素和
    * sum[i,j]=sum[0,j]-sum[0,i-1]
    * sum[i, j] <= k  <==>  sum[0,j]-sum[0,i-1]<=k  <==> sum[0, j] - k <= sum[0, i - 1]
    * 我们注意到sum[0, i - 1]会先计算出来，然后后面才计算出sum[0, j]。
    * 这样的话我们可以把初始化一个cum，同时依次把数组的值加进去。每加一个，就把这个值丢到一个箱子里。并且每次把这个cum - k，
    * 且在箱子里找到比cum - k大的值（这些值可能很多个，但我们只需要最小的那个）
    * */
    public int dpmax(int[] array, int k) {
        int sumArray[]=new int[array.length]; //从小到大排序
        Arrays.fill(sumArray,0);
        int sum=array[0]; // sum[0,j]
        sumArray[0]=sum;
        int res=Integer.MIN_VALUE;
        for (int i=1;i<array.length;i++) {
            sum+=array[i];
            sumArray[i]=sum;
            int index=findindex(sumArray,sum-k); //找到比sum-k大且最接近sum-k的数的位置
            if (index<array.length){ // index>array.length说明array里面的数都比cur - k小，代表没有找到值
                res=Math.max(sum-sumArray[index],res);
            }
            Arrays.sort(sumArray); //排序
        }
        return  res;
    }
    public int findindex(int[] array, int k) {
        int i = 1;
        for (; i <array.length ; i++) {
            if (array[i-1]<k && array[i]>=k){
                return i;
            }
        }
        return i;
    }
    //给定一个长度为n*m的数组，求子矩阵中的所有元素和，这个子和要求不能超过K且最接近K。
    /*
    * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
    *  固定左右边界，统计在此左右边界下的每一行的和，将此每一行的和作为一个数组将问题转化
    *
    * */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k)); //问题转化成：给定一个长度为n的数组，求数组的最大子序和，这个子序和要求不能超过K且最接近K。
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }

}
