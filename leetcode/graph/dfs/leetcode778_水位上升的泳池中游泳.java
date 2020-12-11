package graph.dfs;
/*
  @Date:2020/10/9 16:51
  @Author:Administrator
*/
/*
* tips:
*   · 游向上下左右四个相邻的平台的必要条件是水漫过两个平台
*   · 平台间移动是不花世界的，而需要花时间的是等待水漫过起始平台和目标平台
* */

public class leetcode778_水位上升的泳池中游泳 {
    private int rows;
    private int cols;
    int[][] gird;
    public int swimInWater(int[][] grid) {
        rows=grid.length;
        if (rows==0){
            return 0;
        }
        cols=grid[0].length;
        this.gird=grid;//初始化
        //为二分寻找左右边界
        int right = Integer.MIN_VALUE, left = Integer.MAX_VALUE;
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                right =Math.max(right, grid[r][c]);
                left = Math.min(left, grid[r][c]);
            }
        }
        //二分
        while (left<=right){
            int mid=(left+right)/2;
            boolean[][]marked=new boolean[rows][cols];
            dfs(marked,0,0,mid);
            if (marked[rows-1][cols-1]){ //走到了右下角
                right=mid-1; //向下寻找，可能有更小的阈值
            }else { //走不到右下角
                left=mid+1;
            }
        }
        return left;
    }
    public void dfs(boolean marked[][],int i,int j,int threshold) {
        if (!inArea(i,j) ||marked[i][j]||threshold<gird[i][j]){ //结束深搜
            return;
        }
        marked[i][j]=true; //访问过该节点你
        dfs(marked,i,j-1,threshold);
        dfs(marked,i,j+1,threshold);
        dfs(marked,i-1,j,threshold);
        dfs(marked,i+1,j,threshold);
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
