package tree;
/*
  @Date:2020/11/24 10:57
  @Author:Administrator
*/

import java.util.*;

public class leetcode1339_分裂二叉树的最大乘积 {
    //暴力法
    Map<TreeNode,Long> map=new HashMap<>();
    public int maxProduct(TreeNode root) {
        sum(root);
        long totalSum=map.get(root); //根节点的和
        long res=-1;
        for (TreeNode node: map.keySet()) {
            if (node!=root){
                res=Math.max(res,(totalSum-map.get(node))*(map.get(node)));
            }
        }
        return (int)(res%(1e9+7));
    }
    public long sum(TreeNode root) {
        if (map.containsKey(root)) return map.get(root); //memo 处理
        if (root==null) return 0;
        long left=sum(root.left);
        long right=sum(root.right);
        map.put(root,root.val+left+right);
        return root.val+left+right;
    }
    //和为某个数n的两个数的最大乘积，是某个最接近n/2的数m与 n-m  的乘积
    static  class Solution{
        private int closeToHalf;
        private int half;

        public int maxProduct(TreeNode root) {
            int sum = DFS1(root);
            half = sum / 2;
            DFS2(root);
            return (int) ((long) closeToHalf * (sum - closeToHalf) % 1000_000_007);
        }
        // 求子树之和，并将结果更新保存在节点 val 中
        private int DFS1(TreeNode root) {
            if (root == null) return 0;
            return root.val += DFS1(root.left) + DFS1(root.right); //更新节点的值为当前树所有节点和
        }
        private void DFS2(TreeNode root) {
            if (root == null) return;
            if (Math.abs(closeToHalf - half) > Math.abs(root.val - half)) closeToHalf = root.val;
            //if (root.val <= half) return;   // 剪枝
            DFS2(root.left);
            DFS2(root.right);
        }

    }

    public static void main(String[] args) {
        new leetcode1339_分裂二叉树的最大乘积().maxProduct(TreeNode.stringToTreeNode("[1,null,2,3,4,null,null,5,6]"));
    }

}
