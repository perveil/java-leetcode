package tree;
/*
  @Date:2020/11/1 14:50
  @Author:Administrator
*/

import java.util.*;

public class leetcode95_不同的二叉搜索树 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> res=new ArrayList<>();
        if (start>end){  //此处为空节点
            res.add(null);
            return res;
        }
        if (start==end){
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <=end; i++) { //以i为root
            List<TreeNode> left=generateTrees(start,i-1);
            List<TreeNode> right=generateTrees(i+1,end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode95_不同的二叉搜索树().generateTrees(3);
    }
}
