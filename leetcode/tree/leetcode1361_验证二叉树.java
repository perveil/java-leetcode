package tree;
/*
  @Date:2020/11/15 10:52
  @Author:Administrator
*/

import java.util.*;

public class leetcode1361_验证二叉树 {
    //对于单连通区域，有且只有1个节点的入度数为0，其余节点的入度数都是1。
    //但是对于多联通区域并不一定可行，如何判断是否为多联通图，则需要dfs了
    int[] leftChild, rightChild;
    boolean[] visited;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegreeCnt = new int[n];
        //有且只有1个节点的入度数为0，其余节点的入度数都是1
        for (int i = 0; i < n; i++) {
            if((leftChild[i] != -1 && ++indegreeCnt[leftChild[i]] > 1)
                    || (rightChild[i] != -1 && ++indegreeCnt[rightChild[i]] > 1)) {
                return false; //入度数<1，
            }
        }
        // 上面的判断可以解决单个连通域的树判断、及部分多连通域情况
        // 例如下面的情况无法判断，需要再判断连通域的个数。从root一遍dfs之后，若存在结点未被访问说明多个连通域。
        // 1 <--- 0 <--->  2， 4 --->3
        //找到根节点
        int root = -1;
        for (int i = 0; i < n; i++){
            if (indegreeCnt[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        //处理其他的多联通图
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        visited = new boolean[n];
        dfs(root);
        for (boolean v: visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int v) {
        if (v == -1) {
            return;
        }
        visited[v] = true;
        dfs(leftChild[v]);
        dfs(rightChild[v]);
    }


    public static void main(String[] args) {
        new leetcode1361_验证二叉树().validateBinaryTreeNodes(4,new int[]{
                1,2,0,-1
        },new int[]{
                -1,-1,-1,-1
        });
    }
}
