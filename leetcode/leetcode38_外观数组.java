import java.util.*;

public class leetcode38_外观数组 {
    public String countAndSay(int n) {
        String str="1";
        for (int i = 1; i <n ; i++) {
            char [] chars=str.toCharArray();
            StringBuilder newStr=new StringBuilder();
            char nowchar=chars[0];
            int count=1;
            for (int j = 1; j <str.length() ; j++) {
                if (nowchar!=chars[j]){
                    newStr.append(""+count+nowchar);
                    nowchar=chars[j];
                    count=1;
                }else {
                    count++;
                }
            }
            newStr.append(""+count+nowchar); //末尾
            str=newStr.toString();
        }
        return  str;
    }

    public static void main(String[] args) {
        new leetcode38_外观数组().countAndSay(5);
    }

}
