package tree;
/*
  @Date:2020/10/21 14:29
  @Author:Administrator
*/

import java.util.*;

public class leetcode654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums,int start,int end) {
        if (start>end) return null;
        int index=findMaxIndex(nums,start,end);
        TreeNode root=new TreeNode(nums[index]);
        root.left=constructMaximumBinaryTree(nums,start,index-1);
        root.right=constructMaximumBinaryTree(nums,index+1,end);
        return root;
    }
    public int findMaxIndex(int[] nums,int start,int end) {
        if (start>end) return -1;
        int index=start;
        int max=nums[start];
        for (int i = start+1; i <=end ; i++) {
            if (max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
}
