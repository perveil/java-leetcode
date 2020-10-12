import java.util.*;

public class leetcode532_数组中的kdiff数对 {
    public int findPairs(int[] nums, int k) {
        if(nums.length <2 ||k<0) return 0;
        Arrays.sort(nums);
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        Set<Integer> set=new HashSet<Integer>();

        HashMap<Integer,Integer> diffmap=new HashMap<Integer,Integer>();
        //<int1,int2>:int2-int1=k
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            set.add(i);
        }
        if(k==0){
            for(int num:set){
                res+=map.get(num)>=2?1:0;
            }
            return res;
        }else{
            for (int num:nums) {
                if (set.contains(num+k)){
                    diffmap.put(num,num+k);
                }
            }
        }
        return diffmap.size();
    }
}
