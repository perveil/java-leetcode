package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import tree.*;

public class leetcode297_二叉树的序列化和反序列化 {
    public static void main(String[] args) {
        System.out.println(
                new leetcode297_二叉树的序列化和反序列化().serialize(new leetcode297_二叉树的序列化和反序列化().deserialize("[1,2,3,null,null,4,5]"))
        );
    }
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder();
        int maxHeight=maxDepth(root);
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();  //节点队列，先进先出
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()&&maxHeight-->0) {
            int len=nodeQueue.size();
            for (int i = 0; i <len; i++) {
                TreeNode node=nodeQueue.poll();
                res.append(node.val==-1?"null":node.val+",");
                nodeQueue.add(node.left==null?new TreeNode(-1):node.left);
                nodeQueue.add(node.right==null?new TreeNode(-1):node.right);
            }
        }
        int len=res.length();
        String ans=res.toString().substring(0,len-1);
        return  "["+ans+"]";
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /*
    * 完全二叉树非递归的构造，层次遍历
    * */
    public TreeNode deserialize(String data) {
        if (data.equals("")||data.equals("[]")) return null;
        data = data.trim();                         //去除两侧的空格
        data = data.substring(1, data.length() - 1); //去除[ 、]
        if (data.length() == 0) {
            return null;
        }
        String[] parts = data.split(",");  //split by ,
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));  //root
        Queue<TreeNode> nodeQueue = new LinkedList<>();  //节点队列，先进先出
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) { //遍历结束
                break;
            }

            item = parts[index++];     //node 的左节点
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {  //遍历结束
                break;
            }

            item = parts[index++];         //node的右节点
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
