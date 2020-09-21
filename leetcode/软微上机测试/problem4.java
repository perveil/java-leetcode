package 软微上机测试;/*
  @Date:2020/9/19 14:59
  @Author:Administrator
*/

import java.util.*;

public class problem4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in) ;
        while(reader.hasNext())
        {
            int m = reader.nextInt() ;
            int [] numbers = new int[m] ;
            for(int index=0;index<m;index++)
            {
                numbers[index] = reader.nextInt();
            }
            System.out.println(Arrays.toString(numbers));
        }
    }
}
