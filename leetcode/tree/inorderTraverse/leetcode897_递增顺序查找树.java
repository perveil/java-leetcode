package tree.inorderTraverse;/*
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

     //中序遍历解法，每遍历一个节点就将该节点作为之前节点的右孩子节点
    TreeNode cur;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null; //左子树置空
        cur.right = node;  //前一个节点的右子树是当前节点
        cur = node;        //访问完当前节点，当前节点就会变成下一个节点的前一个节点
        inorder(node.right); 
    }
}
