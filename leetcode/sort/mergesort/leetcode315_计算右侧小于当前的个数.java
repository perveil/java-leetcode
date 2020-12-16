package sort.mergesort;/*
  @Date:2020/12/16 11:48
  @Author:Administrator
*/

import java.util.*;

public class leetcode315_计算右侧小于当前的个数 {
    int[] res;
    public List<Integer> countSmaller(int[] nums) {
        int len=nums.length;
        res=new int[len];
        int[] temp = new int[len]; //合并时候的操作数组
        // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素
        int[] indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        reversePairs(nums,0,len-1,indexes);
        List<Integer> resList=new ArrayList<>();
        if (len==0) return resList;
        for (int i = 0; i <len; i++) {
            resList.add(res[i]);
        }
        return resList;
    }
    private void reversePairs(int[] nums, int left, int right,int []indexs) {
        if(left==right){
            return ;
        }
        int mid=(left+right)>>1;
        reversePairs(nums,left,mid,indexs);
        reversePairs(nums,mid+1,right,indexs);
        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexs[mid]] <= nums[indexs[mid + 1]]) {
            return;
        }
        int i=left; //左侧左边界
        int j=mid+1; //右侧左边界
        //固定左侧数组中的某一个数字nums[k]，去右侧数组中找到的nums[q]满足条件: nums[k]<=nums[q]
        for (; i <= mid; i++) {
            for (; j <=right ; j++) {
                if (nums[indexs[i]]<=nums[indexs[j]]){
                    break;
                }
            }
            res[indexs[i]]+=(j-mid-1);
        }
        int[] sorted = new int[right - left + 1]; //中间数组
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] =  indexs[p2++];
            } else if (p2 > right) {
                sorted[p++] = indexs[p1++];
            } else {
                if (nums[p1] < nums[p2]) {
                    sorted[p++] =  indexs[p1++];
                } else {
                    sorted[p++] = indexs[p2++];
                }
            }
        }
        //将排序之后的中间数组复制到本来的数组中去
        for (int k = 0; k < sorted.length; k++) {
            indexs[left + k] = sorted[k];
        }
    }

    public static void main(String[] args) {
        new leetcode315_计算右侧小于当前的个数().countSmaller(new int[]{
                26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41
        });
    }
}
