package tree;/*
  @Date:2020/12/14 18:27
  @Author:Administrator
*/

import java.util.*;
/*
* tips:
* 1. 树上的每个结点都具有唯一的值
* 2.
* */
public class leetcode863_二叉树中所有距离为K的节点 {
    Map<Integer,List<Integer>> map=new HashMap<>(); //树转邻接表
    Set<Integer> res=new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (K==0){
            res.add(target.val);
            return new ArrayList<>(res);
        }
        inorder(root); //树转邻接表
        int targetVal=target.val;
        //bfs 查找距离target K 个距离的节点
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(targetVal);
        boolean [] marked=new boolean[501];
        marked[targetVal]=true;
        int curstep=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            curstep++;
            for (int i = 0; i <size; i++) {
                int cur=queue.poll();
                for (int j :map.get(cur)) {
                    if (!marked[j]){
                        queue.add(j);
                        marked[j]=true;
                        if (curstep==K) res.add(j);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
    public void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        if (!map.containsKey(root.val)){
            map.put(root.val,new ArrayList<>());
        }
        if (root.right!=null) {
            map.get(root.val).add(root.right.val);
            if (!map.containsKey(root.right.val)){map.put(root.right.val,new ArrayList<>());}
            map.get(root.right.val).add(root.val);
        }
        if (root.left!=null) {
            map.get(root.val).add(root.left.val);
            if (!map.containsKey(root.left.val)){
                map.put(root.left.val,new ArrayList<>());
            }
            map.get(root.left.val).add(root.val);
        }
        inorder(root.right);
    }

    public static void main(String[] args) {
        new leetcode863_二叉树中所有距离为K的节点().distanceK(TreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),new TreeNode(5),2);
    }
}
