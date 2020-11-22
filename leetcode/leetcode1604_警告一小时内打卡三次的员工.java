import java.util.*;

public class leetcode1604_警告一小时内打卡三次的员工 {
    /*
    * 1.半夜11.00-1.00这个时间段
    *
    * */
    Map<String,ArrayList<Integer>> map=new HashMap<>();
    List<String> res=new ArrayList<>();
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int len =keyName.length;
        for (int i = 0; i <len; i++) {
            if (!map.containsKey(keyName[i])){
                map.put(keyName[i],new ArrayList<>());
            }
            map.get(keyName[i]).add(caculateTime(keyTime[i]));
        }
        for (String key:map.keySet()) {
            List<Integer> timelist=map.get(key);
            if (timelist.size()<3) continue; //小于三次的直接过
            if (isInOnHour(timelist)){
                res.add(key);
            }
        }
        Collections.sort(res);  //按照字典序排序
        return res;
    }
    public int caculateTime(String time){
        String [] minAndHour=time.split(":");
        return Integer.valueOf(minAndHour[0])*60+Integer.valueOf(minAndHour[1]);
    }
    //判断是否在一个小时之内有三次签到
    public boolean isInOnHour(List<Integer> list){
        Arrays.sort(list.toArray()); //时间排序
        for (int i = 0; i <list.size() ; i++) {
            int starttime=list.get(i);
            if (i+2<list.size() && list.get(i+2)<=starttime+60){
                return true;
            }
            if (starttime>23*60){ //starttime 在晚上11点到12点
                if (list.get((i+2)%list.size())+22*60<=starttime+60){
                    return true;
                }
            }
        }
        return false;
    }

}
