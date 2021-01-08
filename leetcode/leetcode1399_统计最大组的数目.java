import java.util.*;

public class leetcode1399_统计最大组的数目 {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map=new HashMap<>(); // 数位和尾key的组有value个元素
        int max=-1; //最大组的个数
        for(int i=1;i<=n;i++){
            int num=sum(i);
            map.put(num,map.getOrDefault(num,0)+1);
            max=Math.max(max,map.get(num));
        }
        int res=0;
        for(Integer key:map.keySet()){
            if(map.get(key)==max){
                res++;
            }
        }
        return res;
    }
    //n 的数位求和
    public int sum(int n) {
        int sum=0;
        while(n>=10){
            sum+=n%10;
            n/=10;
        }
        sum+=n;
        return sum;
    }

    public static void main(String[] args) {
        new leetcode1399_统计最大组的数目().countLargestGroup(24);
    }
}
