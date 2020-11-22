import java.util.*;

public class leetcode457_环形数组循环 {
    // 1. 中途不能变方向，索引上的数字，正负需要保持一致
    // 2. 循环长度大于1，可以把循环路径存入一个list中，要求list的长度大于2
    /*
    *   int len=nums.length;
        for (int i = 0; i <len ; i++) { //从i开始,i=startPoint
            List<Integer> path= new ArrayList<>();
            path.add(i);
            int direction=nums[i]>0?1:-1; //从i开始的移动方向
            int nextStep=i;
            while(true){
                if (direction*nums[i]<0){ //中途出现逆向
                    break;
                }
                if (nums[nextStep]<0){
                    nextStep=(nextStep+nums[nextStep]+len)%len;
                }else{
                    nextStep=(nextStep+nums[nextStep])%len; //索引变化
                }
                path.add(nextStep);
                if (nextStep==i){ //找到了
                    break;
                }
            }
            if (path.size()>2&& path.get(0)==path.get(path.size()-1)){
                return true;
            }
        }
        return false;
    *
    * */
    /*
    * 从i位置开始都不是环上的点
    * 重述下无环的判定依据：
        1）当快慢指针指向的新节点发现和上一个节点符号不一致。：运动反向
        2）当快慢指针指向的位置不变时。 ：不动弹
        3）快慢指针指向了不可能是环中节点的节点(该节点位置已经置0的节点)时。 ：目标位置不是环上的点
    * */
    private void setZero(int[] nums, int i){
        int j;
        while(true){
            j = (i + nums[i] + 5000*nums.length) % nums.length; //循环
            if (nums[j] == 0 || nums[i]*nums[j]<0) { //i的下一个点不是环上点 或者 反向进行(不可反向进行)
                nums[i] = 0;
                break;
            }
            nums[i]=0;
            i=j;
        }
    }
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) { //从i开始
            if (nums[i] == 0) continue;
            int lastJ, lastK; //lastJ：慢指针的上一个指针  lastK：快指针的上一个指针
            int j=i, k=i; //j：慢指针,一次走一步 k：快指针一次走两步。从同一个起点出发
            while(true){
                //慢指针走一步
                lastJ=j;
                j=(j+nums[j]+5000*nums.length)%nums.length;
                if (nums[lastJ]*nums[j]<0 ||nums[j]==0||j==lastJ){
                    setZero(nums,i);
                    break;
                }
                //快指针走两步
                for (int l = 0; l <2 ; l++) {
                    lastK = k;
                    k = (k + nums[k] + 5000*nums.length) % nums.length;
                    //原地不动，反向，下一个点是停止节点
                    if (nums[lastK]*nums[k] < 0 || nums[k] == 0 || lastK == k){
                        setZero(nums, i);
                        break;
                    }
                }
                if (j==k){ //快慢指针相遇，判定有环
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new leetcode457_环形数组循环().circularArrayLoop(new int[]{
                        -1,2
                })
        );
    }
}
