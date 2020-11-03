package tree;/*
  @Date:2020/11/3 9:20
  @Author:Administrator
*/

import java.util.*;

public class leetcode889_根据前序和后序遍历构造二叉树 {
    //只有每个节点度为2或者0的时候前序和后序才能唯一确定一颗二叉树，只有一个子节点是无法确定的，
    // 本题只能假设除了叶子节点每个节点的度为2
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,post,0,pre.length-1,0,post.length-1);
    }
    public TreeNode helper(int[] pre,int[] post,int prestart,int preend,int poststart,int postend){
        if(prestart>preend||poststart>postend)return null;

        TreeNode root=new TreeNode(pre[prestart]); //根节点

        if (prestart == preend) //只有一个节点
            return root;
        int index=0;
        while(post[index]!=pre[prestart+1]){ //找到左子树的根节点
            index++;
        }

        //  pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
        /*
        *  [根节点 (左子树根节点.....) (右子树根节点...)] 先序遍历
        *  [（....左子树根节点） (...右子树根节点) 根节点] 后序遍历
        * 左子树：
        *  index：后序遍历中左子树的根节点的索引，index-postStart+1 为左子树长度，从后序遍历看：左子树索引范围（poststart，index）
        *  从先序遍历看，左子树根节点的索引为perstart+1，那么左子树的最后一个节点的索引为：（perstart+1）+（index-postStart+1） -1
        * 右子树：
        *  从先序遍历看：左子树：（perstart+1，prestart+1+index-poststart） 右子树：（prestart+2+index-poststart,preend）
        *  从后序遍历看：左子树：（poststart,index） 右子树：（index+1,postend-1）
        *
        * */
        root.left=helper(pre,post,prestart+1,prestart+1+index-poststart,poststart,index);
        root.right=helper(pre,post,prestart+2+index-poststart,preend,index+1,postend-1);
        return root;
    }
}
