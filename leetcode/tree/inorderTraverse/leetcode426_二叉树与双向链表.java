package tree.inorderTraverse;
/*
  @Date:2020/11/14 11:01
  @Author:Administrator
*/

import tree.TreeNode;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class leetcode426_二叉树与双向链表 {

    Node pre=null; //当前遍历指针的前序结点
    Node head=null;
    public Node treeToDoublyList(Node root) {
        if (root==null) return null;
        helper(root);
        head.left=pre;
        pre.right=head; //pre最终会指向树的中序遍历的最后一个节点
        return head;
    }
    //中序遍历
    public void helper(Node root) {
        if (root==null) return;
        if (pre==null) head=root; //找到了循环链表的首节点
        helper(root.left);
        if (pre!=null) pre.right=root;
        root.left=pre;
        pre=root; //转换指针
        helper(root.right);
    }

}
