import java.util.*;
/*
* 仔细观察发现1 ≤ a[i] ≤ n 这个条件，正好和我们数组的下标差1，我们可以按照数值
* 来遍历数组，那么在数组中具有相同值的元素，会被经过两次，那么我们只要想出一种方式
* 在这个遍历结束后可以区分，哪些元素被经过了多次即可，由于数组元素具有1 ≤ a[i] ≤ n
* 这样的范围，那其实我们当每次经过一个元素时，给他加上n，当遍历结束时，我们再次遍历数组
* 那些数值超过2n的元素索引+1，对应的就是我们的出现了两次的元素。
*
* */
public class leetcode442_数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1)%n] += n; //给对应位置加了n，所以求位置的时候需要对n求余
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) ret.add(i+1);
        }
        return ret;
    }
}
