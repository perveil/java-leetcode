package binarySearch;/*
  @Date:2020/12/14 10:36
  @Author:Administrator
*/

import java.util.*;

public class leetcode275_H指数II {
    //计算某科学家的h-index,总共有h篇论文被引用了至少（大于等于）h次，其余的N-h篇论文每篇被引用次数不多于（小于等于）h
    //设某科学家一共有n篇论文，索引为i的论文的引用数为c=citations[i],所以h=n-i篇论文的引用次数大于等于c=citations[i]，i篇论文的引用次数小于等于citations[i]
    //根据H-Index 的定义：citations[i]>=n-i 答案：n-i
    public int hIndex(int[] citations) {
        int l=0;
        int r=citations.length;
        while(l<r){
            int mid=(l+r)/2;
            if (citations[mid]<citations.length-mid){
                l=mid+1;
            }else{ // citations[mid]==citations.length-mid  寻找左侧边界
                r=mid;
            }
        }
        return citations.length-l;
    }
}
