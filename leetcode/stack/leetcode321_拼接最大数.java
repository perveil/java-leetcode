package stack;/*
  @Date:2020/12/2 11:00
  @Author:Administrator
*/

import java.util.*;

public class leetcode321_拼接最大数 {
    /*
    * 原问题可以转化成：在nums1中选取k1个字符，在nums2中选取k2个字符，k1+k2=k
    * 如何在nums1中选取k1个字符就转换成了leetcode 402（最小） 的逆向问题（最大）
    * */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int res[]=new int[k];
        for (int i = 0; i <=k ; i++) {
            int []nums1s=removeKdigits(nums1,k-i);
            int []nums2s=removeKdigits(nums2,i);
            res=max(merge(nums1s,nums2s),res);
        }
        return res;
    }
    /*
    * 在数组nums 移除 k个数，之后可得到的最大数
    * */
    public int [] removeKdigits(int [] nums, int k) {
        int [] res=new int[nums.length-k];
        int cur=nums.length-k-1; //结果数组的工作指针
        Stack<Integer> stack=new Stack<>();
        for (int num:nums) { //单调递减栈
            while(!stack.isEmpty() &&stack.peek()<num && k>0){
                stack.pop(); //小的数被pop
                k--;
            }
            stack.push(num);
        }
        //没有删除完毕
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }

        while (!stack.isEmpty()) {
            res[cur--]=stack.pop();
        }
        return res;
    }
    /*
    * nums1 、nums可能并不是单调递减的，所以
    * 不能破坏nums1、nums2的相对顺序
    * */
    public int [] merge(int [] nums1, int[] nums2) {
        int k=nums1.length+nums2.length;
        int res[]=new int[k];
        int q=0;
        for (int i = 0; i <nums1.length ; i++) { //先将nums全部插入到res中
            res[i]=nums1[i];
        }
        for (int i = 0; i <nums2.length ; i++) {
            for (int j = 0; j <res.length ; j++) {
                if (nums2[i]>res[j]){
                     //j...k-1 上的元素往后移一位
                    res[j]=nums2[i];
                    break;
                }
            }

        }
        return  res;
    }
    /*
    * nums1 和nums2 的长度都是k
    * 比较对应位的大小
    * */
    public int [] max(int [] nums1, int[] nums2) {
        for (int i = 0; i <nums1.length; i++) {
            if (nums1[i]>nums2[i]){
                return nums1;
            }else if (nums1[i]<nums2[i]){
                return nums2;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        new leetcode321_拼接最大数().removeKdigits(new int[]{
                9, 1, 2, 5, 8, 3
        },2);
    }
}
