import java.util.*;

public class leetcode976_三角形的最大周长 {
    //三角形中的两条边和大于第三条边
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int res=-1;
        for (int i = 0; i <A.length-2; i++) {
            for (int j = A.length-1; j >i ; j--) {
                for (int k = i+1; k <j ; k++) {
                    if (A[i]+A[k]>A[j]){
                        res=Math.max(res,A[i]+A[k]+A[j]);
                    }
                }
            }
        }
        return res;
    }
}
