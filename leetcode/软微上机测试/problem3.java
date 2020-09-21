package 软微上机测试;/*
  @Date:2020/9/19 14:37
  @Author:Administrator
*/

import java.lang.reflect.Array;
import java.util.*;

public class problem3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in) ;
        while(reader.hasNext())
        {
            int m = reader.nextInt() ; //学生个数
            int n=reader.nextInt();    //宿舍楼和教学楼的个数
            if (m==0&&n==0){
                break;
            }
            String [] strs=new String[n]; //读取每一行
            Set<String> peoples=new HashSet<>(); //所有需要隔离的同学，此题目的重点是如何去重
            peoples.add("0");
            for(int index=0;index<=n;index++)
            {
                strs[index]=reader.nextLine().trim();
            }
            for (int i = 1; i <=n ; i++) {
                String [] chars=strs[i].split(" ");
                for (int j=1;j<=Integer.valueOf(chars[0]);j++){
                    if (peoples.contains(chars[i])){ //找到0号感染人员或者是被0号感染者所感染的同学
                        peoples.addAll(Arrays.asList(chars)); //直接全部加入，Set会自动筛选重复的
                    }
                }
            }
            System.out.println(peoples.size());

        }
    }

}
