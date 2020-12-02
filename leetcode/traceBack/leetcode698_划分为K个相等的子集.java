package traceBack;

public class leetcode698_划分为K个相等的子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        int max=0;
        for (int num: nums) {
            sum+=num;
            max=Math.max(max,num);
        }
        if (sum%k!=0 || max>sum/k){
            return  false;
        }
        int aim =sum/k;
        int used[] =new int[nums.length]; //used 指的是数组元素是否用过,1 代表用过，0代表没用过
        return helper(nums,k,0,0,aim,used);
    }
    /*
    * param:
    *   nums:所分割数组
    *   k：要分为几组
    *   cur：当前组的和
    *   start：当前要遍历的元素索引
    *   target：每一组的和
    *   used：nums中元素的使用情况
    * */
    public  boolean helper(int nums[],int k,int cur,int start,int target,int []used){
        if (k==0){ //当前凑了k个组
            return true;
        }
        if (cur==target){
            //当分好某组之后，需要从数组开始重新遍历，寻找下一组
            return helper(nums,k-1,0,0,target,used);
        }
        for (int i = start; i <nums.length; i++) {
            if (used[i]==0 && cur+nums[i]<=target){ //没用过，且与cur的和小于target
                used[i]=1;
                if (helper(nums,k,cur+nums[i],i+1,target,used)){
                    return true;
                }
                used[i]=0; //回溯
            }
        }
        return  false;
    }


    public static void main(String[] args) {
        new leetcode698_划分为K个相等的子集().canPartitionKSubsets(
                new int[]{
                        4, 3, 2, 3, 5, 2, 1
                },4
        );
    }
}
