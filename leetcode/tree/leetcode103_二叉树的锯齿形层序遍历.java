package tree;/*
  @Date:2020/12/22 19:33
  @Author:Administrator
*/

import java.util.*;

public class leetcode103_二叉树的锯齿形层序遍历 {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return levels;
        Stack<TreeNode> oddstack = new Stack<>(); //奇数层栈
        Stack<TreeNode> evenstack=new Stack<>();       //偶数层栈
        oddstack.add(root);
        int level=1; //起始层数为1
        while ( oddstack.size()>0||evenstack.size()>0 ) {
            List<Integer> curLevel=new ArrayList<>();
            int level_length = level%2==1?oddstack.size():evenstack.size();
            Stack<TreeNode> curStack = level%2==1?oddstack:evenstack;
            Stack<TreeNode> nextLevelStack = level%2==1?evenstack:oddstack;
            for(int i = 0; i < level_length; ++i) { //遍历本层所有节点
                TreeNode node = curStack.pop();
                curLevel.add(node.val);
                if (level%2==1){
                    if (node.left != null)  nextLevelStack.add(node.left);
                    if (node.right != null) nextLevelStack.add(node.right);
                }else {
                    if (node.right != null) nextLevelStack.add(node.right);
                    if (node.left != null)  nextLevelStack.add(node.left);
                }
            }
            level++;
            levels.add(curLevel);
        }
        return levels;
    }

    public static void main(String[] args) {
        new leetcode103_二叉树的锯齿形层序遍历().zigzagLevelOrder(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]"));
    }
}
