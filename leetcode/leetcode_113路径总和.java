import tree.TreeNode;

import java.util.*;

public class leetcode_113路径总和 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> queue=new ArrayList<>();
        path(root,sum,queue);
        return  res;
    }
    public void path(TreeNode root, int sum, List<Integer> queue) {
        if (root==null&& sum==0){ //到了叶子节点的子节点
            res.add(new ArrayList<>(queue));
            return;
        }
        queue.add(root.val);
        if(root.left!=null) path(root.left,sum-root.val,queue);
        if(root.right!=null) path(root.right,sum-root.val,queue);
        queue.remove(queue.size()-1); //回溯
    }

    public static void main(String[] args) {
        new leetcode_113路径总和().pathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]"),22);
    }
}
