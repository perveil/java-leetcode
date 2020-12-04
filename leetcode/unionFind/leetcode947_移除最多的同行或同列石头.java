package unionFind;
/*
  @Date:2020/12/3 9:55
  @Author:Administrator
*/

import java.util.*;
/*
* 问题转换成求所有的联通分量，找到了所有联通分量之后，总有办法使每一个联通分量只剩下一个元素
* tips：
   1 <= stones.length <= 1000
   0 <= stones[i][j] < 10000
* */
public class leetcode947_移除最多的同行或同列石头 {
/*
*  对于一个坐标（i，j）的石子来说，需要把行i和列j合并，因为并查集是一维的（0 <= stones[i][j] < 10000），用j+10000表示j
*  在将所有石子的行和列都合并好之后
*  看下一共有多少个联通分量即可，
*  如何求并查集中有多少个联通分量：
*  对每一个节点进行遍历，将每一个节点的父节点加入一个Set中，最后会得到联通分量的个数
* */
    public int removeStones(int[][] stones) {
        int N=stones.length;
        DSU dsu=new DSU(20000);
        for(int [] stone:stones){
            dsu.union(stone[0],stone[1]+10000);
        }
        Set<Integer> parentsNum=new HashSet<>();
        for (int [] stone:stones) {
            parentsNum.add(dsu.find(stone[0]));
        }
        return  N-parentsNum.size();
    }
    //并查集经典结构，并查集是一维的
    class DSU {
        int[] parent;
        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) //初始化时，每个节点的父节点是自己本身
                parent[i] = i;
        }
        public int find(int x) { //找x的父节点
            if (parent[x] != x) parent[x] = find(parent[x]);  // 如果x的父节点不是x本身，则去找x的父节点的父节点...向下递归
            return parent[x];
        }
        public void union(int x, int y) { //合并x与y，把x集合的父节点指向y的父节点
            parent[find(x)] = find(y);
        }
    }

    public static void main(String[] args) {
        new leetcode947_移除最多的同行或同列石头().removeStones(new int[][]{
                {0,0},{0,2},{1,1},{2,0},{2,2}
        });
    }
    }

