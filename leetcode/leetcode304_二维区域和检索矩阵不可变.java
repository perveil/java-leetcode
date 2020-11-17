import java.util.*;
class NumMatrix {
    int [][] matrix;
    int [][] presum;
    int cols;
    int rows;
    public NumMatrix(int[][] matrix) {
        this.rows=matrix.length;
        this.cols=matrix[0].length;
        this.matrix=matrix;
        this.presum=new int[rows][cols];
        //初始化前缀和数组
        for (int i = 0; i <rows ; i++) {
            int sum=0;
            for (int j = 0; j <cols ; j++) {
                sum+=matrix[i][j];
                presum[i][j]=sum;
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (col1>=cols||col2>=cols||row1>=rows||row2>=rows){
            return 0;
        }
        int sum=0;
        for (int i = row1; i <=row2 ; i++) {
            sum+=presum[i][col2]-presum[i][col1-1];
        }
        return sum;
    }
}
public class leetcode304_二维区域和检索矩阵不可变 {
    public static void main(String[] args) {
        new NumMatrix(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}}).sumRegion(2, 1, 4, 3);
    }
}
