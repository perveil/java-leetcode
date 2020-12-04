import java.util.*;

public class leetcode149_直线上最多的点数 {
    //固定一个点，求其他点与该点的斜率，斜率相同在所有点在同一条直线上
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res=0;
        for (int i = 0; i <n-1; i++) {
            Map<String, Integer> slope = new HashMap<>(); // Key :斜率， Value 与第i个点斜率为Key的点的个数
            int repeat=0; //points 数组里边有相同的点，那么相同的点肯定是在一条直线上的
            int tmp_max=0;
            for (int j = i+1; j <n; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if (dy == 0 && dx == 0) {
                    repeat++;
                    continue;
                }
                int g=gcd(dy,dx); //最大公约数
                if (g!=0){ // g不可能是0
                    dy/=g;
                    dx/=g;
                }
                String tmp = String.valueOf(dy) + "/" + String.valueOf(dx);
                slope.put(tmp, slope.getOrDefault(tmp, 0) + 1);
                tmp_max = Math.max(tmp_max, slope.get(tmp)); //在和第i点同一条直线且不重合的点的个数
            }
            res=Math.max(res,repeat+tmp_max+1);
        }
        return res;
    }
    //约分，求x，y的最大公倍数
    private int gcd(int dy, int dx) {
        if (dx==0) return dy;
        return gcd(dx,dy%dx);
    }
}
