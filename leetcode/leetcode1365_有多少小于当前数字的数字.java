import java.util.*;

public class leetcode1365_有多少小于当前数字的数字 {
    //暴力
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length==0) return new int[]{};
        Map<Integer,List<Integer>> map=new HashMap<>();
        int len=nums.length;
        for (int i = 0; i <len; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        Arrays.sort(nums); //排序统计
        int curnum=nums[len-1];
        int [] res=new int[len];
        for (int i = len-1; i >-1; i--) {
            if (nums[i]==curnum){
                continue;
            }else{ // nums[i]!=curnum
                for (Integer index: map.get(curnum)) {
                    res[index]=i+1;
                }
                curnum=nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1365_有多少小于当前数字的数字().smallerNumbersThanCurrent(new int[]{
                7,7,7,7
        });
    }
}
