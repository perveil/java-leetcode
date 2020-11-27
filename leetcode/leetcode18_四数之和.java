import java.util.*;

public class leetcode18_四数之和 {
    //去重是针对当前所遍历元素的
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int len=nums.length;
         //查找第一个元素
        for (int i = 0; i <len-3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //剪枝
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i+1; j <len-2; j++) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //剪枝
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len- 2] + nums[len - 1] < target) {
                    continue;
                }
                int left= j+1;
                int right=len-1;
                int curTarget=target-nums[i]-nums[j];
                while (left<right){
                    if (nums[left]+nums[right]==curTarget){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        //去重
                        while (left<right && nums[left]==nums[left+1])
                            left++;
                        while (left<right && nums[right]==nums[right-1])
                            right--;
                        //进行下次搜索
                        right--;
                        left--;
                    }else if(nums[left]+nums[right]<curTarget){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode18_四数之和().fourSum(new int[]{
                1, 0, -1, 0, -2, 2
        },0);
    }
}
