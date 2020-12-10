package tree.线段树;
/*
  @Date:2020/12/10 19:51
  @Author:Administrator
*/

import java.util.*;

public class leetcode327_区间和的个数 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        //preSum[0]=0; persum[i]=nums[0...i-1]的和  persum[j]-persum[i]=nums[i+1....j]的和
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        // 区间离散化
        Set<Long> allNumbers = new TreeSet<Long>();
        for (long x : preSum) {
            allNumbers.add(x); //将persum 值插入是为了提前构建线段树的叶子节点
            allNumbers.add(x - lower);
            allNumbers.add(x - upper);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }
        SegNode root=build(0,allNumbers.size()-1); //建树
        int ret=0;
        for (long x:preSum) {
            int left=values.get(x-upper);
            int right=values.get(x-lower);
            ret+=count(root,left,right);
            insert(root,values.get(x));
        }
        return ret;
    }
    //建树
    public SegNode build(int left, int right) {
        SegNode node = new SegNode(left, right);
        if (left == right) {
            return node;
        }
        int mid = (left + right) / 2;
        node.lchild = build(left, mid);
        node.rchild = build(mid + 1, right);
        return node;
    }
    //统计处于[left,right] 的个数
    public int count(SegNode root, int left, int right) {
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }
    //插入
    public void insert(SegNode root, int val) {
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
    /*
    * 线段树中分为叶子节点和内部节点
    *  叶子节点：lo===hi ,表示一个元数据
    *  内部节点：表示区间[lo,hi] ，是一个区间，mid=(lo+hi)/2 左子树所代表的区间：[lo,mid] 右子树所代表的区间[mid+1,hi]
    *
    * */
    class SegNode {
        int lo, hi, add;
        SegNode lchild, rchild;

        public SegNode(int left, int right) {
            lo = left;
            hi = right;
            add = 0;
            lchild = null;
            rchild = null;
        }
    }

    public static void main(String[] args) {
        new leetcode327_区间和的个数().countRangeSum(new int[]{
                -2,5,-1
        },-2,2);
    }

}
