package tree.线段树;/*
  @Date:2020/12/16 11:12
  @Author:Administrator
*/

import java.util.*;

public class SegNode {
    int lo, hi, add;
    SegNode lchild, rchild;

    public SegNode(int left, int right) {
        lo = left;
        hi = right;
        add = 0;
        lchild = null;
        rchild = null;
    }
    //建树
    public static SegNode build(int left, int right) {
        SegNode node = new SegNode(left, right);
        if (left == right) {
            return node;
        }
        int mid = left + (right - left) / 2;
        node.lchild = build(left, mid);
        node.rchild = build(mid + 1, right);
        return node;
    }
    //统计处于[left,right] 的个数
    public static int count(SegNode root, int left, int right) {
        if (left > root.hi || right < root.lo||left>right) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }
    //插入
    public static void insert(SegNode root, int val) {
        root.add++; //遍历到了该节点，所以val 属于该节点所对应的区间
        if (root.lo == root.hi) { //遍历到了叶子节点
            return;
        }
        int mid = (root.lo + root.hi) / 2;
        if (val <= mid) {
            insert(root.lchild, val);
        } else {
            insert(root.rchild, val);
        }
    }

}
