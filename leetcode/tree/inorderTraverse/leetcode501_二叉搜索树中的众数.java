package tree.inorderTraverse;
/*
  @Date:2020/9/24 8:52
  @Author:Administrator
*/

import tree.TreeNode;

import java.util.*;

public class leetcode501_二叉搜索树中的众数 {
    int maxTimes=0; //所有节点中某节点出现的最大次数
    int curTimes=1; //当前节点出现的次数
    ArrayList<Integer> res=new ArrayList<>();
    TreeNode pre =null; //!
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[]{};
        inOrder(root);

        int ans[]=new int[res.size()];
        int j=0;
        for(Integer i: res){
            ans[j++]=i;
        }
        return ans;
    }
    /*
      params:
        pre:root 节点的前一个节点
        root:当前访问节点
    */
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left); //!
        if(pre!=null)
            curTimes=(root.val==pre.val)?curTimes+1:1;
        if(curTimes==maxTimes){
            res.add(root.val);
        }else if(curTimes>maxTimes){
            res.clear(); //清除
            res.add(root.val);
            maxTimes=curTimes;
        }
        pre=root;//当前节点访问结束，成为右子树的最左节点的前一个节点
        inOrder(root.right);
    }

    public static void main(String[] args) {
        new leetcode501_二叉搜索树中的众数().findMode(TreeNode.stringToTreeNode("[1,null,2,2]"));
    }
}
