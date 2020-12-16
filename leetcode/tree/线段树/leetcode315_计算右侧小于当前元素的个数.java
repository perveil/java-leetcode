package tree.线段树;
/*
  @Date:2020/12/16 10:50
  @Author:Administrator
*/

import java.util.*;



public class leetcode315_计算右侧小于当前元素的个数 {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) return res;
        //获取区间范围
        int start = nums[0], end = nums[0];
        for(int i = 0; i < len; i++){
            if(nums[i] < start) start = nums[i];
            if(nums[i] > end) end = nums[i];
        }
        //构建树
        SegNode root = SegNode.build(start, end);
        //从右向左，边插入边计数
        for(int i = len - 1; i >= 0; i--){
            //计数小于该元素的区间，所以要减一
            res.addFirst(SegNode.count(root, start, nums[i] - 1));
            SegNode.insert(root, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode315_计算右侧小于当前元素的个数().countSmaller(new int[]{
                5,2,2,1
        });
    }
}

