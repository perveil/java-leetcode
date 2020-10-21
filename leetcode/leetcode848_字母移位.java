import java.util.*;

public class leetcode848_字母移位 {
    //S.length = shifts.length
    public String shiftingLetters(String S, int[] shifts) {
        if (shifts.length==0||S=="") return "";
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i+1] % 26;  //防止超过int最大值
        }
        //此时的shifts[i]，表示S.charAt(i)向后移动几个单位
        StringBuilder res=new StringBuilder();
        for (int i = 0; i <shifts.length ; i++) {
            res.append((char)((S.charAt(i)-'a'+shifts[i])%26+'a'));

        }
        return res.toString();
    }

    public static void main(String[] args) {
        new leetcode848_字母移位().shiftingLetters("abc",new int[]{
                3,5,9
        });
    }
}
