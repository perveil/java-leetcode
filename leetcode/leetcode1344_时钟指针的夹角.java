import java.util.*;

public class leetcode1344_时钟指针的夹角 {
    public double angleClock(int hour, int minutes) {
        // 1<=hour<=12,以刻度12为0°
        double minDiv60=(minutes*1.0)/60;
        double angleOfhour=(hour%12+minDiv60)*30;
        double angleOfmin=minDiv60*360;

        return Math.abs(angleOfhour-angleOfmin);
    }

    public static void main(String[] args) {
        new leetcode1344_时钟指针的夹角().angleClock(12,30);
    }
}
