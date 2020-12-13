import java.util.*;

public class leetcode554_砖墙 {
    public int leastBricks(List<List<Integer>> wall) {
        int height=wall.size(); //墙的高度
        int res=height;
        Map<Integer,Integer>  map=new HashMap<>(); //key->value=以key为砖块边缘的行数为value，答案求最大的value
        for (int i = 0; i <height ; i++) {
            List<Integer> row=wall.get(i);
            int start=0;
            for (int j=0;j<row.size()-1;j++) {
                start+=row.get(j);
                map.put(start,map.getOrDefault(start,0)+1);
                res=Math.min(height-map.get(start),res);
            }
        }
        return  res;
    }

    public static void main(String[] args) {

    }
}
