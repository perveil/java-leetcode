package tree.postorderTraverse;/*
  @Date:2020/10/7 17:36
  @Author:Administrator
*/

import tree.TreeNode;

import java.util.*;

public class leetcode897_递增顺序查找树 {
    TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return null;
        }
        root.right = increasingBST(root.right);
        if(root.left!=null){
            TreeNode node = root.left;
            root.left = null;
            head = node;
            while(node.right!=null)
                node = node.right;
            node.right = root; //该节点左子树的最右节点的右节点指向root
            return increasingBST(head);
        }
        else
            return root;
    }
}
