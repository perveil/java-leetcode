import java.util.*;

public class leetcode1184_公交站之间的距离 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis=0;
        int reverdis=0;
        int len =distance.length;
        //求顺时针距离
        int cur=start;
        while(cur!=destination){
            dis+=distance[cur];
            cur=(cur+1)%len;
        }
        cur=start;
        while(cur!=destination){
            reverdis+=distance[cur-1==-1?len-1:cur-1];
            cur=cur-1==-1?len-1:cur-1;
        }
        return Math.min(dis,reverdis);
    }

    public static void main(String[] args) {
        new leetcode1184_公交站之间的距离().distanceBetweenBusStops(new int[]{1,2,3,4},0,3);
    }
}
