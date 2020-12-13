package 分治;/*
  @Date:2020/12/13 10:25
  @Author:Administrator
*/

import java.util.*;

public class leetcode217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        return  mergeSort(nums,0,nums.length-1);
    }
    public boolean mergeSort(int[] nums,int l,int r) {
        if (l >= r) return false; //当l>=r，划分的子数组只有一个元素时，则不存在重复元素
        //划分
        int mid=(l+r)/2;
        if (mergeSort(nums,l,mid)||mergeSort(nums,mid+1,r)) return true;
        //合并
        int temp[]=new int[r-l+1]; //合并l...r之间的数字
        int left=l; //左数组的遍历指针
        int right=mid+1; // 右数组的遍历指针
        int cur=0;
        while(left<=mid ||right<=r){
            if (left>mid){
                temp[cur++]=nums[right++];
            }else if (right>r){
                temp[cur++]=nums[left++];
            }else{
                if (nums[left]<nums[right]){
                    temp[cur++]=nums[left++];
                }else{
                    temp[cur++]=nums[right++];
                }
            }
            if (cur>=1&&temp[cur]==temp[cur-1]){
                return true;
            }
        }
        for (int i = 0; i <temp.length ; i++) {
            nums[l+i]=temp[i];
        }
        return  false;
    }
}
