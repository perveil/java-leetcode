import java.util.*;

public class leetcode453_最小移动次数使数组元素相等 {
    /*
    *
    *为了让最小元素等于最大元素，至少需要加k次。在那之后，最大元素可能发生变化。因此，我们一次性增加增量 k=max-min，并将移动次数增加 k。
    * 然后，对整个数组进行扫描，找到新的最大值和最小值，重复这一过程直到最大元素和最小元素相等。
    *
    * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/ 排序
    * */
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }
}
