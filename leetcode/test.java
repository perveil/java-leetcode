import java.util.*;

public class test {
    public int waysToMakeFair(int[] nums) {
        int len=nums.length;
        int [] left=new int[len];  //left[i]: 0...i 中奇数索引数的和
        int [] right=new int[len]; //right[i] : i..len-1 中奇数索引数的和

        int [] leftSum=new int[len];  //leftSum[i]: 0...i 数的和
        int [] rightSum=new int[len]; //rightSum[i] : i..len-1 数的和
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            leftSum[i]=sum;
        }
        sum=0;
        for(int i=len-1;i>-1;i--){
            sum+=nums[i];
            rightSum[i]=sum;
        }
        sum=0;
        for(int i=0;i<len;i++){
            sum+=i%2==0?0:nums[i];
            left[i]=sum;
        }
        sum=0;
        for(int i=len-1;i>-1;i--){
            sum+=i%2==0?0:nums[i];
            right[i]=sum;
        }
        int res=0;
        for(int i=0;i<len;i++){ //删除i
            int sumOfeven=0;
            int sumOfodd=0;
            if(i>0){
                sumOfodd+=left[i-1];
                sumOfeven+=(leftSum[i-1]-left[i-1]);
            }
            if(i<len-1){
                sumOfeven+=right[i+1];
                sumOfodd+=(rightSum[i+1]-right[i+1]);
            }
            if(sumOfeven==sumOfodd){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        new test().waysToMakeFair(new int[]{
                2,1,6,4
        });
    }
}
