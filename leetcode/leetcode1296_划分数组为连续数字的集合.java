import java.util.*;

public class leetcode1296_划分数组为连续数字的集合 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (k==1) return true;
        if (nums.length%k!=0) return false;
        if (nums.length<k) return false;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int curlen=nums.length;
        for (int num:nums) {
            if (curlen==0) return true;
            if (map.get(num)>0){
                map.put(num,map.get(num)-1);
                curlen--;//除去num 所占的位置
                for (int i = 1; i <k ; i++) {
                    if (!map.containsKey(num+i)) return false;
                    if (map.get(num+i)>=1){map.put(num+i,map.get(num+i)-1); curlen--;}
                    else return false;
                }
            }
        }
        return curlen==0;
    }

    public static void main(String[] args) {
        new leetcode1296_划分数组为连续数字的集合().isPossibleDivide(new int[]{
                3,2,1,2,3,4,3,4,5,9,10,11
        },3);
    }
}
