package tree;/*
  @Date:2020/12/9 11:59
  @Author:Administrator
*/

import java.util.*;

public class leetcode515_在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node= queue.remove();
                max=Math.max(node.val,max);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
