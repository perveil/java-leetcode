package sort.quicksort;/*
  @Date:2020/10/7 16:08
  @Author:Administrator
*/

import java.util.*;
/*
* 思路1：设置两个数组索引r1、r2,
* r1：包括r1位置上的和r1左边的所有元素小于1 [0]
* r2:包括r2位置熵的和r2左边的所有元素小于2[0,1]
* 遍历到数组中的元素nums[i]时：
*    if nums[i]<2 则说明r2所代表的区间[0,1]变大则
*       r2++;
*       swap(nums,nums[i],nums[r2])
*       if(nums[i]<1) 则说明r2所代表的区间[0]变大则
*          r1++;
*          swap(nums,nums[r2],nums[r1])
*思路2：
*   将0放在数组头部，将2放在数组尾部,同样使用两个指针r1,r2
*   r1:0-(r1-1) 位置区间上的数字为0
*   r2：r2+1-(nums.length-1) 位置区间上的数字为2
*
* */
public class leetcode75_颜色分类 {

    public void sortColors(int[] nums) {
        int r1 = -1;
        int r2 = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 2)
            {
                r2++;
                swap(nums,i,r2);
                if(nums[r2] < 1)
                {
                    r1++;
                    swap(nums,r1,r2);
                }
            }

        }

    }
    void swap(int[]nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new leetcode75_颜色分类().sortColors(new int[]{
                2,0,2,1,1,0
        });
    }
}
