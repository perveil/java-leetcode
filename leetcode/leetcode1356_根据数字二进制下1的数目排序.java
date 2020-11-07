import java.util.*;

public class leetcode1356_根据数字二进制下1的数目排序 {
    /*
    *  Integer.bitCount(i) 计数i的二进制中的1的个数
    *  Stream 写法
    * */
    public int[] sortByBits(int[] arr) {
        Integer[] Arr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(Arr,(o1,o2)->{
            int c1=count(o1);
            int c2=count(o2);
            return  c1==c2?o1-o2:c1-c2;
        });
        return Arrays.stream(Arr).mapToInt(Integer::intValue).toArray();
    }
    public int count(int n){
        int count=0;
        for (int i = 0; i <32 ; i++) {
            count+=(n>>i) &1;
        }
        return count;
    }


    public static void main(String[] args) {
        new leetcode1356_根据数字二进制下1的数目排序().count(12);
    }
}
