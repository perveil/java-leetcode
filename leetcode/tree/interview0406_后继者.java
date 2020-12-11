package tree;/*
  @Date:2020/12/11 11:15
  @Author:Administrator
*/

import java.util.*;

public class interview0406_后继者 {
    boolean isFind=false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null||p==null) return null;
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur!=null){  //左子树全进栈，先遍历左子树
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(isFind) return cur;
            if(cur.val==p.val) isFind=true; //找到了目标元素,下一个要遍历遍历的元素就是答案
            cur = cur.right;
        }
        return null;
    }
}
