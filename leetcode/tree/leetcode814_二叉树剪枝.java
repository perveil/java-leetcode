package tree;/*
  @Date:2020/10/23 11:57
  @Author:Administrator
*/

import java.util.*;

public class leetcode814_二叉树剪枝 {
    /*
     如果某节点是val是1，则向下递归，如果某节点是0，则需要验证该节点的左右子树中是否有1，没有就直接删除
   */
    public TreeNode pruneTree(TreeNode root) {
        if (root==null) return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.val==0){
            int left=countOne(root.left);
            int right=countOne(root.right);
            if (left+right==0){
                return null;
            }
        }
        return root;
    }
    //查找改左右子树的1的个数
    public int countOne(TreeNode root) {
        if (root==null) return 0;
        return root.val==1?1+countOne(root.right)+countOne(root.left):countOne(root.right)+countOne(root.left);
    }
}
