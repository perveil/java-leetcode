package heap;
/*
  @Date:2020/10/20 10:11
  @Author:Administrator
*/

import java.util.*;

public class leetcode373_查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(((o1, o2) ->compare(o2,o1)));//逆序排序，从小到大
        for (int i : nums1) {
            for (int j : nums2) {
                int[] arr = new int[]{i, j};
                if (queue.size() < k) {
                    queue.offer(arr);
                } else if (!queue.isEmpty() && compare(queue.peek(), arr) > 0) { //弹出
                    queue.poll();
                    queue.offer(arr);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
        }
        return res;
    }
    private int compare(int[] arr1, int[] arr2) {
        return (arr1[0] + arr1[1]) - (arr2[0] + arr2[1]);
    }

}
