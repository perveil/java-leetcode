import java.util.*;

public class leetcode986_区间列表的交集 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lenA=A.length;
        int lenB=B.length;
        List<int[]> res=new ArrayList<>(); //结果数组
        if (lenA==0 ||lenB==0) return  res.toArray(new int[res.size()][2]);
        int i=0; //A数组遍历指针
        int j=0; //B数组遍历指针
        while (i<lenA&&j<lenB){
            int left=Math.max(A[i][0],B[j][0]);
            int right=Math.min(A[i][1],B[j][1]);
            if (left<=right){
                res.add(new int[]{left,right});
            }
            if (A[i][1]<B[j][1]){ //留下右侧边界最远的
                i++;
            }else{
                j++;
            }
        }
        return  res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        new leetcode986_区间列表的交集().intervalIntersection(new int[][]{
                {5,10}
        }, new int[][]{
                {3,10}
        });
        // {0,2},{5,10},{13,23},{24,25}  {1,5},{8,12},{15,24},{25,26}
    }
}
