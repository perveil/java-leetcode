package binarySearch;/*
  @Date:2020/12/14 17:24
  @Author:Administrator
*/

import java.util.*;

public class interview1005_稀疏数组搜索 {
    public int findString(String[] words, String s) {
        if (s.length()==0) return -1;
        int l=0;
        int r=words.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            int tmp=mid;
            while(mid>=l&& words[mid]=="") mid--;
            //避开""
            int compare=words[mid].compareTo(s);
            if (compare==0){
                return mid;
            }else if (compare<0){
                l=tmp+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new interview1005_稀疏数组搜索().findString(new String[]{
                        "at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""
                },"car")
        );

    }
}
