import java.util.*;

public class leetcode498_对角线遍历 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int []res=new int[rows*cols];
        int resi=0;
        int times=rows+cols-1; //单趟次数
        for (int i = 0; i <times ; i++) {
            if (i%2==0){ //从下向上
                for (int j=rows-1; j >-1 ; j--) {
                    for (int k=0; k <cols ;k ++) {
                        if (j+k>i) break;
                        if (j+k==i){
                            res[resi++]=matrix[j][k];
                        }
                    }
                }
            }else { //从上向下
                for (int j=0; j <rows ; j++) {
                    if (j>i) break;
                    for (int k=cols-1; k >-1 ;k --) {
                        if (j+k<i) break;
                        if (j+k==i){
                            res[resi++]=matrix[j][k];
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new leetcode498_对角线遍历().findDiagonalOrder(new int[][]{
                {1, 2, 3},{4, 5, 6}
        });
    }
}
