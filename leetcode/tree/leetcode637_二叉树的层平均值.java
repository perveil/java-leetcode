package tree;/*
  @Date:2020/10/21 17:10
  @Author:Administrator
*/

import com.sun.source.tree.Tree;

import java.util.*;

public class leetcode637_二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for (int i = 0; i <size ; i++) {
                TreeNode node=queue.poll();
                if (node.right!=null) queue.add(node.right);
                if (node.left!=null)  queue.add(node.left);
                sum+=node.val;
            }
            res.add(sum/(size*1.0));
        }
        return res;
    }
}
