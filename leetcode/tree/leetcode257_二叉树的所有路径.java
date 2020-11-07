package tree;/*
  @Date:2020/11/6 10:02
  @Author:Administrator
*/

import java.util.*;

public class leetcode257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if(root==null) return ans;
        pathHelper(root,ans,"");
        return ans;
    }
    public void pathHelper(TreeNode root, List<String> ans,String cur) {
        if(root==null) return;
        if(root.right==null && root.left==null){
            cur+="->"+root.val;
            ans.add(cur.substring(1,cur.length()));
            return;
        }
        cur+="->"+root.val;
        pathHelper(root.left,ans,cur);
        pathHelper(root.right,ans,cur);
    }
}
