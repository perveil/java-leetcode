import java.util.*;

public class leetcode1200_最小绝对值间隔的数对 {
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
