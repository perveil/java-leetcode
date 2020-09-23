package sildeWindow;

import java.util.*;

public class leetcode611_有效三角形的个数 {

    //三角形的原则；两条边的和大于第三条边
    public boolean isTriangle(int l1,int l2,int l3) {
        return l1+l2>l3 && l1+l3>l2 && l2+l3>l1;
    }

    public int triangleNumber(int[] nums) {
        int i,j,k,n=nums.length,r=0;
        Arrays.sort(nums);
        for(i=0;i<n;++i){
            for(j=i+1;j<n;++j){
                for(k=j+1;k<n;++k){
                    if(nums[i]+nums[j]>nums[k]){
                        r+=nums.length-k+1;
                        break;
                    }
                }
            }
        }
        return r;
    }

    //双指针解法：固定最大的，寻找合适的小的
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int res = 0;
            for (int i = n - 1; i >= 2; --i) {
                int l = 0, r = i - 1;
                while (l < r) {
                    if (nums[l] + nums[r] > nums[i]) {
                        res += r - l;
                        --r;
                    } else {
                        ++l;
                    }
                }
            }
            return res;
        }
    }


}
