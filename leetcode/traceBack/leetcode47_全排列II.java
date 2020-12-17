package traceBack;/*
  @Date:2020/12/17 10:49
  @Author:Administrator
*/

import java.util.*;

public class leetcode47_全排列II {
    List<List<Integer>> result =new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] vis=new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> perm = new ArrayList<>();
        perm(nums,0,vis,perm);
        return result;
    }
    //给idx位置上放置元素
    public void perm(int[] nums,int idx,boolean [] vis,List<Integer> perm) {
        if (idx==nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if ( vis[i]||(i>0 &&nums[i]==nums[i-1]&&!vis[i-1])) continue;
            // 当有多个相同元素都没有访问过，而且它们的位置相邻，所以（i>0 &&nums[i]==nums[i-1]&&!vis[i-1]）==true 时
            // 说明在选择索引为i的元素的时候，前边有一个相同的元素没有被选择，而我们要在idx上只放置一次相同的元素。
            // 相同的&未访问过的 元素只能在idx位置上边的放一次
            vis[i]=true;
            perm.add(nums[i]);
            perm(nums, idx+1, vis,perm); //接下来安置idx+1 位置上的元素
            vis[i]=false; //回溯
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        new leetcode47_全排列II().permuteUnique(new int[]{
               1,1,2,2
        });
    }
}
