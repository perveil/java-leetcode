package LinkedList;/*
  @Date:2020/10/23 10:21
  @Author:Administrator
*/

import java.util.*;

public class leetcode234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        ListNode slow=head;
        ListNode fast=head.next;
        /*
         * 快慢指针找中点,最终slow 指向中点
         * 有奇数个节点时，指向正中心
         * 偶数个节点时，指向后一半的前一个（前一半的最后一个）
         * */
        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next; //后半段的链表的头节点
        slow.next=null; //断链
        head2=reverseList(head2); //反转链表
        while(head!=null &&head2!=null){
            if (head.val!=head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode  perv=null;
        ListNode  cur=head;
        ListNode  next=head.next;
        while(cur!=null){
            cur.next=perv;
            if(next==null) break;
            perv=cur;
            cur=next;
            next=cur.next;
        }
        return cur; //返回反转后的首节点
    }

    public static void main(String[] args) {
        new leetcode234_回文链表().isPalindrome(ListNode.stringToListNode("[1,2]"));
    }
}
