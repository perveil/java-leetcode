import java.util.*;

public class leetcode1109_航班预定统计 {
    /*暴力解法
    *   int []res =new int[n];
        for (int i = 0; i <bookings.length; i++) {
            for (int j = bookings[i][0]; j <=bookings[i][1] ; j++) {
                res[j-1]+=bookings[i][2];
            }
        }
        return res;
    * */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }

    public static void main(String[] args) {
        new leetcode1109_航班预定统计().corpFlightBookings(new int[][]{
                {1,2,10},{2,3,20},{2,5,25}
        },5);
    }
}
