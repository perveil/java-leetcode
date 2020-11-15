package tree;/*
  @Date:2020/11/11 19:41
  @Author:Administrator
*/

import java.util.*;

public class leetcode1008_前序遍历构造二叉树 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length<1){
            return null;
        }
        return produceTree(preorder,0,preorder.length-1);
    }
    public TreeNode produceTree(int[] preorder,int start,int end) {
        if(start>end) return null;
        TreeNode root=new TreeNode(preorder[start]);
        if(start==end) return new TreeNode(preorder[start]);
        int i=start+1;
        while(i<preorder.length&&preorder[i]<preorder[start]){ // preorder[i]>preorder[start]
            i++;
        }
        root.right=produceTree(preorder,start+1,i-1);
        root.left=produceTree(preorder,i,end);
        return root;
    }

    public static void main(String[] args) {
        new leetcode1008_前序遍历构造二叉树().bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
}
