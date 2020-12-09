package tree;
/*
  @Date:2020/12/9 10:19
  @Author:Administrator
*/

import java.util.*;

public class leetcode1104_二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        Stack<Integer> stack=new Stack<>();
        while(label!=0){
            stack.add(label);
            label=calParent(label); //向上递归
        }
        List<Integer> res=new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    public int calParent(int x){
        //计算出x所在的层数
        int curLevel=1;
        while(Math.pow(2,curLevel)-1<x){
            curLevel++;
        }
        //前curlevel-1层的所有节点个数
        int prevLevelNum=(int)Math.pow(2,curLevel-1)-1;
        int curnum=x-prevLevelNum; //当前节点距离本层开始节点中间夹了多少个节点
        int res= (int) (prevLevelNum-Math.floor((curnum*1.0)/2));
        return curnum%2==0?res+1:res;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode1104_二叉树寻路().calParent(1));
    }
}
