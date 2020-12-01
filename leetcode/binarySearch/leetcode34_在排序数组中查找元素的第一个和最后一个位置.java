package leetcode.binarySearch;

public class leetcode34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        new leetcode.binarySearch.leetcode34_在排序数组中查找元素的第一个和最后一个位置().searchRange(
                new int[]{
                        1
                },1
        );
    }
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[2];
        result[0]=result[1]=-1;
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){ //head>tail 推出循环,tail==head 的时候也可能存在解
            int md=(head+tail)/2;
            if(target==nums[md]){
                result[0]=result[1]=md;
                int before=md;
                int after=md;
                while(--before>-1&&nums[before]==target){}
                result[0]=before+1;
                while(++after<nums.length&&nums[after]==target){}
                result[1]=after-1;
                break;
            }else if(target>nums[md]){
                head=md+1;
            }else{
                tail=md-1;
            }
        }
        return result;

    }
}
