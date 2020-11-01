package sort;/*
  @Date:2020/11/1 10:16
  @Author:Administrator
*/

import java.util.*;

public class leetcode969_煎饼排序 {
    /*
    * 最笨的方法是类似于冒泡排序那样，两个两个反转，找到最小值，每次确定未排序序列的最小值的最终位置，
    * 依然使用每次确定一个元素的位置的想法，找到未排序序列的最大值x，反转最大值之前以及最大值 的序列，此时，最大值在序列头部，再次反转整个未排序序列，
    * 此时，x到达其最终位置
    * */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list=new ArrayList<>();
        int len=arr.length;
        for (int i = 1; i < len; i++) { //需要找到len-1个最大值
            int maxindex=findMax(arr,0,len-i);
            if (maxindex!=0){
                reverse(arr,0,maxindex);
                list.add(maxindex+1);
            }
            reverse(arr,0,len-i);
            list.add(len-i+1);
        }
        return list;
    }
    public int findMax(int[] arr,int start,int end) {
        int max=arr[start];
        int maxIndex=start;
        for (int i = start+1; i <=end ; i++) {
            if (arr[i]>max){
                max=arr[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    public void reverse(int[] arr,int start,int end) {
        if (start==end){
            return;
        }
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //最小的绝对值差一定是在排序之后相邻的元素对里边产生的
        Arrays.sort(arr);
        int min_gap=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            min_gap=Math.min(Math.abs(arr[i]-arr[i-1]),min_gap);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])==min_gap){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
