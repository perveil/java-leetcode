package sort;
/*
  @Date:2020/10/7 16:35
  @Author:Administrator
*/

import java.util.*;

public class interview1616_部分排序 {
    public int[] subSort(int[] array) {
        int left =-1;
        int right=-1;
        for (int i = 1; i <array.length ; i++) {
            if (array[i]<array[i-1]){ //出现错误
                int j=i-2;
                while(j>-1 &&array[j]>array[i]){
                    j--;
                }
                left=j+1;
                break;//找到最左边界
            }
        }
        for (int i = array.length-2; i >-1 ; i--) {
            if (array[i]>array[i+1]){ //出现错误
                int j=i+2;
                while(j<array.length &&array[j]<array[i]){
                    j++;
                } //找到第一个大于array[i]的数
                right=j-1;
                break;//找到最右边界
            }
        }

        return  new int[]{
                left,right
        };
    }

    public static void main(String[] args) {
        new interview1616_部分排序().subSort(new int[]{
                1,2,4,7,10,11,7,12,6,7,8,18,19
        });
    }
}
