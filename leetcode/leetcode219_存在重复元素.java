import java.util.*;

public class leetcode219_存在重复元素 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        for(int i=0;i<len;i++){
            int preIndex=map.getOrDefault(nums[i],-1);
            if ((preIndex!=-1)&&(i-preIndex<=k)){
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
         new leetcode219_存在重复元素().containsNearbyDuplicate(new int[]{
                 1,2,3,1,2,3
         },2);
    }
}
