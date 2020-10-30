package tree;/*
  @Date:2020/10/29 9:39
  @Author:Administrator
*/

import java.util.*;

public class leetcode894_所有可能的满二叉树 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N % 2 == 0) {
            return ans;
        }
        if (N == 1) { //当前树只有一个节点时，此节点是该子树的根节点，结束递归
            TreeNode head = new TreeNode(0);
            ans.add(head);
            return ans;
        }
        // 求比N小的 &&和为N-1的两个奇数（左右子树）
        for (int i = 1; i < N; i += 2) { // i<N ,遍历范围（1，N-2）
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) { //排列组合
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    ans.add(head);
                }
            }
        }
        return ans;
    }
}
