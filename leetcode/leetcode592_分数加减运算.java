import java.util.*;

public class leetcode592_分数加减运算 {
    //分子分母通分、分子相减、分子分母约分
    public String fractionAddition(String expression) {
        /*
         统一格式，便于切分
         expression = expression.replace("-", "+-");
         String[] splits = expression.split("\\+");
        * */
        expression = expression.replace("-", "+-");
        String[] splits = expression.split("\\+");
        int[] fenzi = new int[splits.length];
        int[] fenmu = new int[splits.length];
        int sumfenmu = 1; //通分

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].length()==0) continue;
            fenzi[i] = Integer.parseInt(splits[i].split("/")[0]);
            fenmu[i] = Integer.parseInt(splits[i].split("/")[1]);
            sumfenmu *= fenmu[i];
        }
        int sum = 0; //分子的计算
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].length()==0) continue;
            sum += sumfenmu / fenmu[i] * fenzi[i];
        }
        int yueshu = this.GCD(sum, sumfenmu);
        return sum / yueshu + "/" + sumfenmu / yueshu;

    }

    //求最大公约数 GCD算法
    public int GCD(int m, int n) {
        m = Math.abs(m);
        n = Math.abs(n);
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    public static void main(String[] args) {
        new leetcode592_分数加减运算().fractionAddition("-1/3-1/2");
    }
}
