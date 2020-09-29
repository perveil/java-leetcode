package recursion;
/*
  @Date:2020/9/28 11:22
  @Author:Administrator
*/

import tree.TreeNode;

import java.util.*;

public class leetcode437_路径总和III {
    int pathnumber;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Sum(root,sum); //以root 为起始节点去递归
        pathSum(root.left,sum); //以root.left 为起始节点去递归
        pathSum(root.right,sum);//以root.right 为起始节点去递归
        return pathnumber;
    }


    public void Sum(TreeNode root, int sum){
        if(root == null) return;
        sum-=root.val;
        if(sum == 0){
            pathnumber++;
        }
        Sum(root.left,sum);
        Sum(root.right,sum);
    }
}
