package graph.dfs;
/*
  @Date:2020/10/12 15:18
  @Author:Administrator
*/

//题意是往下跳，反向思考：往上爬
public class leetcode1340_跳跃游戏V {
    int []arr;
    int d;
    int n;
    int[] maxlen;
    public int maxJumps(int[] arr, int d) {
        this.arr=arr;
        this.d=d;
        this.n=arr.length;
        maxlen=new int[n]; //maxlen 指的是从当前结点出发，能访问的最多索引数
        int ret=0;
        for (int i = 0; i <arr.length ; i++) {
            ret=Math.max(ret,dfs(i));
        }
        return ret;
    }
    public int dfs(int cur){
        if (maxlen[cur]!=0) return maxlen[cur];
        int ret=1;
        for (int i = cur+1; i <=Math.min(n-1,cur+d) &&arr[i]<arr[cur] ; i++) {
            // arr[i]<arr[cur] 保证是递减的
            ret=Math.max(ret,dfs(i)+1);
        }
        for (int i = cur-1; i>=Math.max(0,cur-d) &&arr[i]<arr[cur] ; i--) {
            // arr[i]<arr[cur] 保证是递减的
            ret=Math.max(ret,dfs(i)+1);
        }
        maxlen[cur]=ret;
        return  ret;
    }
}
