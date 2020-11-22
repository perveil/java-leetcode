import java.util.*;

public class leetcode495_提莫攻击 {
    /*
    *  timeseries 是一个递增的正整数序列
    *  问题转化成了合并区间
    * */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int [][] intervals=new int[timeSeries.length][2];
        for (int i = 0; i <timeSeries.length; i++) {
            intervals[i][0]=timeSeries[i];
            intervals[i][1]=timeSeries[i]+duration;
        }
        int [][] mergeResult=merge(intervals);
        int res=0;
        for (int i = 0; i <mergeResult.length; i++) {
            res+=mergeResult[i][1]-mergeResult[i][0];
        }
        return res;
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0||intervals.length==1) return intervals;
        List<int[]> list = new ArrayList<>();
        //依据首元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //前后合并
        for (int i = 1; i < intervals.length ; i++) {
            //intervals[i][0] intervals[i][1] 分别表示i+1的区间合并完之后的左侧、右侧边界
            if (intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = intervals[i][0] < intervals[i-1][0] ? intervals[i][0] : intervals[i-1][0];
                intervals[i][1] = intervals[i][1] < intervals[i-1][1] ? intervals[i-1][1] : intervals[i][1];
            }else{ //此时无法合并，加入已合并完成的元素
                list.add(intervals[i-1]);
            }
            //区间末尾是最后一个合并完成的区间
            if (i==intervals.length-1){
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][]);
    }
}
