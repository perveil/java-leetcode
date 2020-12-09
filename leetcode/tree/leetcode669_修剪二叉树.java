package tree;/*
  @Date:2020/12/9 11:17
  @Author:Administrator
*/

import java.util.*;

public class leetcode669_修剪二叉树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null) return null;
        if (root.val<low){
            return trimBST(root.right,low,high);
        }
        if (root.val>high){
            return  trimBST(root.left,low,high);
        }
        //root 在[low,high] 的范围内
        root.right=trimBST(root.right,low,high);
        root.left=trimBST(root.left,low,high);
        return root;
    }
}
