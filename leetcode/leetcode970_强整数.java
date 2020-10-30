import java.util.*;

public class leetcode970_强整数 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        double num=1;
        int i = 0;
        for (;num<bound ; i++) {
            num=Math.pow(x,i);
        }
        num=1;
        i--;
        int j = 0;
        for (;num<bound ; j++) {
            num=Math.pow(y,j);
        }
        j--;
        Set<Integer> ans=new HashSet<>();
        List<Integer> ans1=new ArrayList<>();
        for (int k = 0; k <=i ; k++) {
            for (int l = 0; l <=j ; l++) {
                num=Math.pow(x,k)+Math.pow(y,l);
                if (num<=bound){
                    ans.add((int)num);
                }
            }
        }
        for (int n:
             ans) {
            ans1.add(n);
        }
        return ans1;
    }

    public static void main(String[] args) {
        new leetcode970_强整数().powerfulIntegers(2,3,10);
    }
}
