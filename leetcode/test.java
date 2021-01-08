import java.util.*;

public class test {

    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int sum = 0,val = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            sum += s[i];
            if (sum <= 0)break;
            val += sum;
        }
        return val;
    }

    public static void main(String[] args) {
        new test().maxSatisfaction(new int[]{
                -1,-8,0,5,-9
        });
    }
}
