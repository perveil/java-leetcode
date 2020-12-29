package tree;/*
  @Date:2020/12/29 9:09
  @Author:Administrator
*/

import java.util.*;

public class leetcode513_找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        int res=-1;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            res=queue.peek().val;
            for (int i = 0; i <size ; i++) {
                TreeNode node=queue.poll();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return  res;
    }
}
