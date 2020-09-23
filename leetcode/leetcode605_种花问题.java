import java.util.*;

public class leetcode605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
         //flowerbed[i]=2 表示不能再种植
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i]==1){
                if (i>0) flowerbed[i-1]=2;
                if (i<flowerbed.length-1) flowerbed[i+1]=2;
            }
        }
        int max=0; //最多可以放多少盆花
        for (int i = 0; i <flowerbed.length ;) {
            if (flowerbed[i]==0){
                int len=1;
                while(i<flowerbed.length-1&&flowerbed[++i]==0){
                    len++; //0得长度++
                }
                max+=len==1?1:len-1;
            }
            i++;
        }
        return max>=n;
    }

    public static void main(String[] args) {
        new leetcode605_种花问题().canPlaceFlowers(new int[]{
                1,0,0,0,1,0,0
        },2);
    }
}
