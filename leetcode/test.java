import java.util.*;

public class test {
    public int minSubarray(int[] nums, int p) {
        //求前缀和
        int len=nums.length;
        long sum=0;
        for (int i = 0; i <len; i++) {
            sum+=nums[i];
        }
        if (sum%p==0) return 0;
        if (sum<p) return -1; //不可能
        long rest=sum%p; //寻找数组和%p==rest的子数组，整体数组减去该子数组
        int res=nums.length;
        Map<Long,Integer> map=new HashMap<>(); // sum[0...i]%p为Key的子数组左侧边界
        map.put((long)0,0);
        sum=0;
        for (int i = 0; i <len ; i++) { //从前向后遍历
            sum+=nums[i];
            Integer index=map.get((sum-rest)%p);
            if (index!=null){
                res=Math.min(res,i-index);
            }
            map.put(sum % p, i); //将右侧边界赋值给左侧边界
        }
        return res==nums.length?-1:res;
    }
    public static void main(String[] args) {
        new test().minSubarray(new int[]{
                1,1,1
        },2);
    }
}
