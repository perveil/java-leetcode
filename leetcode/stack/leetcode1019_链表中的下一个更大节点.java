package stack;/*
  @Date:2020/10/13 9:15
  @Author:Administrator
*/

import java.util.*;
import LinkedList.ListNode;

public class leetcode1019_链表中的下一个更大节点 {
    static  class Node{
        ListNode node;
        int index;
        Node  next;
        Node(ListNode node,int index){
            this.node=node;
            this.index=index;
        }
        public void setNext(Node next){
            this.next=next;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        int len =0;
        ListNode cur=head;
        Node nodeList=new Node(null,-1);// 新链表的头节点
        Node curOfNodeList=nodeList;
        while(cur!=null){
            Node newNode=new Node(cur,len);
            curOfNodeList.next=newNode;
            curOfNodeList=curOfNodeList.next;
            len++;
            cur=cur.next;
        }
        if (len<1)return new int[]{};
        int []res=new int[len];
        Stack<Node> stack=new Stack<>();
        curOfNodeList=nodeList.next;
        stack.add(curOfNodeList);
        curOfNodeList=curOfNodeList.next;
        while(curOfNodeList!=null){ //单调递减栈
            while(!stack.isEmpty() && curOfNodeList.node.val>stack.peek().node.val){
                Node node=stack.pop();
                res[node.index]=curOfNodeList.node.val;
            }
            stack.push(curOfNodeList);
            curOfNodeList=curOfNodeList.next;
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode1019_链表中的下一个更大节点().nextLargerNodes(ListNode.stringToListNode("[1,7,5,1,9,2,5,1]"));
    }
}
