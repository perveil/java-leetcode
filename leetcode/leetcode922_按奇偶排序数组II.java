import java.util.*;

public class leetcode922_按奇偶排序数组II {
    /*
  一半数是奇数、一半数是偶数
  */
    public int[] sortArrayByParityII(int[] A) {
        int worngodd=0;
        int worngeven=0;
        boolean odd=false;
        boolean even=false;
        int i=0;
        while(i<A.length&&(worngeven<A.length || worngodd<A.length)){
            if(i%2==0){ //索引是偶数
                if(A[i]%2!=0 &&!even){
                    worngeven=i;
                    even=true;
                }
            }else{ //索引是奇数
                if(A[i]%2==0&&!odd){
                    worngodd=i;
                    odd=true;
                }
            }
            if(even && odd){
                int temp=A[worngodd];
                A[worngodd]=A[worngeven];
                A[worngeven]=temp;
                even=false;
                odd=false;
                i=Math.min(worngeven,worngodd);
            }
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        new leetcode922_按奇偶排序数组II().sortArrayByParityII(new int[]{
                648,831,560,986,192,424,997,829,897,843
        });
    }
}
