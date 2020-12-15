package binarySearch;/*
  @Date:2020/12/15 22:05
  @Author:Administrator
*/

import java.util.*;

public class leetcode378_有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int l=matrix[0][0];
        if (k==1) return l;
        int r=matrix[n-1][n-1];
        // [l,r]
        while(l<=r){ //l==r+1 时跳出
            int mid=(l+r)/2;
            if (k<=numOfSmallerThanMid(matrix,mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public int numOfSmallerThanMid(int matrix[][],int mid){
        int n=matrix.length-1; //行
        int m=0;  //列
        int res=0;
        while(n>-1 && m<matrix.length){
            if (matrix[n][m]<=mid){
                res+=n+1;
                m++;
            }else{ //matrix[n][m]>mid
                n--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode378_有序矩阵中第K小的元素().kthSmallest(new int[][]{
                {1,2},{2,3}
        },2);
    }
}
