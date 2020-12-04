package traceBack;
/*
  @Date:2020/12/4 9:35
  @Author:Administrator
*/

import java.util.*;

public class leetcode659_分割数组为连续子序列 {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
            for (int x : nums) {
                int count = countMap.getOrDefault(x, 0) + 1;
                countMap.put(x, count);
            }
            for (int x : nums) {
                int count = countMap.getOrDefault(x, 0);
                if (count > 0) {
                    int prevEndCount = endMap.getOrDefault(x - 1, 0);
                    if (prevEndCount > 0) {
                        countMap.put(x, count - 1);
                        endMap.put(x - 1, prevEndCount - 1);
                        endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                    } else {
                        int count1 = countMap.getOrDefault(x + 1, 0);
                        int count2 = countMap.getOrDefault(x + 2, 0);
                        if (count1 > 0 && count2 > 0) {
                            countMap.put(x, count - 1);
                            countMap.put(x + 1, count1 - 1);
                            countMap.put(x + 2, count2 - 1);
                            endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }


    public static void main(String[] args) {
        new leetcode659_分割数组为连续子序列().isPossible(new int[]{
                1,2,3,4,4,5
        });
    }
}
/*
    public boolean isPossible(int[] nums) {
        int[] visited=new int[nums.length];
        System.out.println(
                helper(visited,nums)
        );
        return helper(visited,nums);
    }
    public boolean helper(int [] visited,int []nums){
        if (sum(visited)==nums.length){
            return true;
        }
        boolean res=false;
        for (int i = 0; i <nums.length ; i++) {
            if (visited[i]==0){ //该元素没有访问过
                visited[i]=1;
                int len=1;
                int num=nums[i];
                List<Integer> list=new ArrayList<>();
                list.add(i);
                for (int j = i+1; j <nums.length; j++) {
                    if (visited[j]!=1&&nums[j]==num+1){
                        if (len>=3){
                            int [] tempVisited=visited.clone();
                            res= res|| helper(tempVisited,nums);
                        }
                        len++;
                        num=nums[j];
                        visited[j]=1;
                        list.add(j);
                    }
                }
                if (len<3){ // 长度小于3，回溯
                    for (int index: list) {
                        visited[index]=0;
                    }
                    return false;
                }
            }
        }
        return  res;
    }
    public int sum(int []nums){
        int res=0;
        for (int num:nums) {
            res+=num;
        }
        return res;
    }
* */
