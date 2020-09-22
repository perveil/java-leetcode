package tree.postorderTraverse;
/*
  @Date:2020/9/22 9:28
  @Author:Administrator
*/

import java.util.*;
public class leetcode968_监控二叉树 {
    /*
    * 0=>这个结点待覆盖
    * 1=>这个结点已经覆盖
    * 2=>这个结点上安装了相机
    * */
    int res=0;
    public int minCameraCover(leetcode.tree.TreeNode root) {
        if (postOrder(root)==0){ //如果根节点是待覆盖的
            res++;
        }
        return  res;
    }
    /*
    *  return：返回的是当前节点的状态，0，1，2
    *
    * */
    int postOrder(leetcode.tree.TreeNode node) {
        if (node==null){
            return 1;
        }
        int left=postOrder(node.left);
        int right=postOrder(node.right);
        if (left==0||right==0){ //如果左右两个子节点有一个是没有被覆盖的，当前节点就得安上监控
            res++;
            return  2;
        }
        if (left==1&&right==1){ //如果左右两个子节点都被覆盖了，此时寄希望于当前节点的父节点安上监控
            return  0;
        }
        if (left+right>=3){ //只要有一个子节点安上监控，则当前节点已经被监控
            return 1;
        }

        return -1;
    }
}
