package graph.拓扑排序;
/*
  @Date:2020/12/11 13:44
  @Author:Administrator
*/

import java.util.*;
/*
*  拓扑排序步骤：
*  1. 从DGA图中找到一个没有前驱的顶点输出。(可以遍历，也可以用优先队列维护)
   2. 删除以这个点为起点的边。(它的指向的边删除，为了找到下个没有前驱的顶点)
   3. 重复上述1，2，直到最后一个顶点被输出。如果还有顶点未被输出，则说明有环！
* */
public class leetcode210_课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res=new int[numCourses];
        int cur=0; //res的工作指针
        //统计各个节点的入度
        int [] indegrees=new int[numCourses];    //indegrees[i]：第i个节点的入度
        Queue<Integer> queue=new ArrayDeque<>(); //装着入度为0所有节点，
        List<List<Integer>> adj=new ArrayList<>();// 邻接表，使用邻接矩阵可能内存溢出
        for (int i = 0; i <numCourses ; i++) { //初始化邻接表
            adj.add(new ArrayList<>());
        }
        for (int [] a:prerequisites) { // a[0]<-a[1]
            indegrees[a[0]]++;
            adj.get(a[1]).add(a[0]);
        }
        //入度为0首先入队
        for (int i = 0; i <numCourses ; i++) {
            if (indegrees[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int pre=queue.poll();
            //删除所有以pre为首部的所有边==>pre 指向所有节点的入度-1
            res[cur++]=pre;
            numCourses--; //剩下没有加入到结果数组的节点个数，遍历结束后如果有节点没有加入结果数组，则说明图中有环
            for (int des:adj.get(pre)) {
                if (--indegrees[des]==0) queue.add(des); // 如果-1之后，des的入度==0 ，则将其加入到队列中
            }
        }
        if (numCourses==0){
            return  res;
        }
        return  new int[0]; //有环
    }
}
