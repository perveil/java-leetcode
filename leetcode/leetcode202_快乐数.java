import java.util.*;

public class leetcode202_快乐数 {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        Set<Integer> set=new HashSet<>();
        int temp=n;
        while(true){
            int sum=0;
            while(temp>9){
                sum+=(temp%10)*(temp%10);
                temp=temp/10;
            }
            sum+=temp*temp;
            if(sum==1) return true;
            temp=sum; //赋予新值
            if(set.contains(temp)){
                return false; //出现循环
            }
            set.add(temp);
        }
    }
}
