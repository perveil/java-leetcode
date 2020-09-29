package tree.postorderTraverse;/*
  @Date:2020/9/29 8:34
  @Author:Administrator
*/

import tree.TreeNode;

import java.util.*;
/*
*
前中后序遍历的非递归写法
 while( 栈非空 || p 非空)
{
  if( p 非空)
  {

  }
   else
  {

  }
}
*
*
*
* */
public class leetcode145_二叉树的后序遍历 {
    //递归方式
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorderOfrecurs(TreeNode root) {
        if(root == null)
            return res;
        postorderOfrecurs(root.left);
        postorderOfrecurs(root.right);
        res.add(root.val);
        return res;
    }
    //非递归方式
    public List<Integer> postorderOfNorecurs(TreeNode root) {
        TreeNode p = root,r = null;
        //p:当前访问节点  r：访问p的之前一个节点
        List<Integer>ans = new ArrayList();
        Deque<TreeNode>s = new ArrayDeque();
        while(!s.isEmpty() || p != null){
            if(p != null)
            {
                s.push(p);
                p = p.left;
            }else{
                p=s.peek();
                if (p.right==null || p.right==r){
                    //当p.right为null，或者此节点之前访问的节点是p的右子节点，说明当前节点访问结束
                    ans.add(p.val);
                    r=p;
                    s.poll();
                    p=null; //当前节点访问结束之后，需要
                }else{
                    p=p.right; //向右子树转移
                }

            }
        }
        return ans;
    }
}
