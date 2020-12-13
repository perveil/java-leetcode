import java.util.*;

public class leetcode1051_高度检查器 {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int [] temp=Arrays.copyOfRange(heights,0,n-1);
        int res=0;
        for(int i=0;i<n;i++){
            if (temp[i]!=heights[i]){
                res++;
            }
        }
        return  res;
    }
}
