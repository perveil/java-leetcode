package stack;/*
  @Date:2020/9/29 10:21
  @Author:Administrator
*/

import java.util.*;

public class leetcode145_最小栈 {
    private Node head;
    public void push(int x){
        if (head==null){
            head=new Node(x,x);
        }{
            head=new Node(x,Math.min(x,head.min),head); //头插法
        }
    }
    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min; //每一个节点都存储着此链表的最小值
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }
        //头插法
        private Node(int val, int min, Node next) { //构造函数的返回值
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
