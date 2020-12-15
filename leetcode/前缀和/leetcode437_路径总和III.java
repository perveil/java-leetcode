package 前缀和;
/*
  @Date:2020/12/15 10:23
  @Author:Administrator
*/

import tree.TreeNode;
import java.util.*;
// 树结构的前缀和：不属于前缀的，我们就要去掉它。
public class leetcode437_路径总和III {
    int res=0;
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1); //初始化
        // 前缀和的递归回溯思路
        recursionPathSum(root, prefixSumCount, sum, 0);
        return res;
    }
    public void recursionPathSum(TreeNode root,  Map<Integer, Integer> prefixSumCount ,int target,int cursum) {
        if (root== null) {
            return ;
        }
        cursum += root.val;
        res+=prefixSumCount.getOrDefault(cursum-target,0);
        prefixSumCount.put(cursum, prefixSumCount.getOrDefault(cursum, 0) + 1);

        recursionPathSum(root.left, prefixSumCount, target, cursum);
        recursionPathSum(root.right, prefixSumCount, target, cursum);

        prefixSumCount.put(cursum, prefixSumCount.get(cursum) - 1); //单路径回溯
    }

    public static void main(String[] args) {
        new leetcode437_路径总和III().pathSum(TreeNode.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]"),8);
    }
}
