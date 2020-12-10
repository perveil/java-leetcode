import java.util.*;

public class leetcode860_柠檬水找零 {
    //有顺序的！！
    public boolean lemonadeChange(int[] bills) {
        int [] coins=new int[2];
        //coins[0] :5块的个数
        //coins[1]:10块的个数
        int num=0; //20块的个数
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                coins[0]++;
            }else if(bills[i]==10){
                coins[1]++;
                coins[0]--;
            }else{  // 20 块可以找10 5 或者 5 5 5
                int num15=Math.min(coins[0],coins[1]); //10+5 组合的个数
                if (num15>0){ //有15
                    coins[1]--;
                    coins[0]--;
                }else{ //没有15
                    coins[0]-=3; //剩下的都用5+5+5 找钱
                }
            }
            //不够用直接返回
            if (coins[0]<0 ||coins[1]<0){
                return false;
            }
        }
        return coins[0]>=0 && coins[1]>=0;
    }

    public static void main(String[] args) {
        System.out.println(
                new leetcode860_柠檬水找零().lemonadeChange(new int[]{
                        5,5,5,5,20,20,5,5,5,5
                })
        );

    }
}
