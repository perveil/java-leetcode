package 贪心;

public class leetcode738_单调递增的数字 {
    public int monotoneIncreasingDigits(int N) {
        if(N<10) return N;
        String str=N+"";
        char []chars=str.toCharArray();
        int len=chars.length;
        int [] numbers=new int[len];
        for (int i = 0; i <len; i++) {
            numbers[i]=chars[i]-'0';
        }
        int flag = len; //index >=flag 的所有位都置9
        for (int i = len-1; i >0 ; i--) {
            if (numbers[i]<numbers[i-1]){
                flag=i;
                numbers[i-1]-=1;
            }
        }
        int res=0;
        for (int i = 0; i < len; i++) {
            if (i>=flag){
                numbers[i]=9;
            }
            res+=numbers[i]*Math.pow(10,len-i-1);
        }
        return res;
    }
    /*
    * 2213 => 尾部置9，向前借位1 2209 => 0<2,倒数第二位置9，向前位借位1 2199 => 2>1,倒数第三位置9，向前借位1，1999
    * 206  => 尾部置9，向前借位 2(-1)9 => 2>-1 ,倒数第二位置9，向前位借1 199=>到达第一位，剩余1，则为199
    * 120  => 尾部置9，向前借位119 =>1==1 119
    * 989998=>989989=>989899=>988999=>988999=>899999
    * */

    public static void main(String[] args) {
        System.out.println(
                new leetcode738_单调递增的数字().monotoneIncreasingDigits(10)
        );
    }
}
