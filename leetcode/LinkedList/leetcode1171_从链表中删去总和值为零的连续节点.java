package LinkedList;/*
  @Date:2020/10/31 13:27
  @Author:Administrator
*/

import java.util.*;
public class leetcode1171_从链表中删去总和值为零的连续节点 {
    /*
    * 尝试滑动窗口失败
    * */
    public ListNode removeZeroSumSublistsOFsilceWindows(ListNode head) {
        if (head==null) return null;
        ListNode temp=new ListNode(-1);
        temp.next=head;
        ListNode pre=temp;
        ListNode left=head;
        ListNode right=head;
        int sum=0;
        ListNode next=head.next;
        while (right!=null){
            sum+=right.val;
            if (right.val<0 && sum>0){
                while(left!=right && sum>0){
                    sum-=left.val;
                    pre=left; //left移动时，更新pre
                    left=left.next;
                }
            }
            if (sum==0){ //出现了总和为0的连续节点
                pre.next=next;
                left=pre;
                right=pre;
                next=right.next;
                sum+=left.val;
            }
            right=right.next;
            next=right==null?null:right.next;
        }
        return temp.next;
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val; //前缀和
            map.put(sum, d);
        }
        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        //如果和为sum的节点只有一个， d.next = map.get(sum).next; 也不会有任何影响
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;

    }
    public static void main(String[] args) {
        new leetcode1171_从链表中删去总和值为零的连续节点().removeZeroSumSublists(ListNode.stringToListNode("[1,2,3,-3,-2]"));
    }
}
