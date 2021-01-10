import java.util.*;

public class test {
    public double binarySearch(double x){
        //精度：小数点后六位0.000001
        //x < 0 取反
        //   -1<x<1
        boolean isNeg=x<0;
        boolean isSmallerThanOne=Math.abs(x)<1;
        x=isNeg?-x:x;
        double l=0;   //l:left
        double r=isSmallerThanOne?x*10:x; // r:right
        while(l<r){
            double mid=(l+r)/2;
            if (Math.abs(mid*mid-x)<0.000001){
                return  isNeg?-mid:mid;
            }else if (mid*mid<x){
                l=mid;
            }else { //mid*mid > x
                r=mid;
            }
        }
        return  isNeg?-l:l;
    }
    public static void main(String[] args) {
    }
}
