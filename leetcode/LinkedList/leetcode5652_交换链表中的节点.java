package LinkedList;/*
  @Date:2021/1/10 23:04
  @Author:Administrator
*/

import java.util.*;

public class leetcode5652_交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        // 寻找正数第K个节点
        ListNode tempNode=new ListNode(-1);
        tempNode.next=head;
        ListNode pre=tempNode;
        ListNode kthNode=head;
        ListNode kthNodenext=head.next;
        int temp=k;
        while(--temp>0){
            pre=kthNode;
            kthNode=kthNodenext;
            kthNodenext=kthNode.next;
        }
        //寻找倒数第K个节点
        ListNode p=kthNode;
        ListNode reversekthNodepre=tempNode;
        ListNode reversekthNode=head;
        ListNode reversekthNodenext=head.next;
        while(p.next!=null){
            reversekthNodepre=reversekthNode;
            reversekthNode=reversekthNodenext;
            reversekthNodenext=reversekthNode.next;
            p=p.next;
        }
        if (reversekthNode.next==kthNode){ //要交换的节点相邻

        }
        if (kthNode.next==reversekthNode){

        }

        pre.next=reversekthNode;
        reversekthNode.next=kthNodenext;

        reversekthNodepre.next=kthNode;
        kthNode.next=reversekthNodenext;

        return tempNode.next;
    }

    public static void main(String[] args) {
        new leetcode5652_交换链表中的节点().swapNodes(ListNode.stringToListNode("[7,9,6,6,7]"),5);
    }
}
