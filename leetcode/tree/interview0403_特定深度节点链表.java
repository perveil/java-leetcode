package tree;
/*
  @Date:2020/11/14 10:41
  @Author:Administrator
*/


import java.util.*;
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x;
    }
}
public class interview0403_特定深度节点链表 {
    //层次遍历
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res=new ArrayList<>();
        if (tree==null) return new ListNode[0];
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            int size=queue.size();
            ListNode head=new ListNode(-1);
            ListNode cur=head; //工作指针
            for (int i = 0; i <size ; i++) {
                TreeNode node=queue.poll();
                if (node.right!=null) queue.add(node.right);
                if (node.left!=null) queue.add(node.left);
                cur.next=new ListNode(node.val);
                cur=cur.next;
            }
            res.add(head.next);
        }
        ListNode[] ans = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
