import java.util.*;

public class leetcode165_比较版本号 {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0); //Integer.valueOf 可以自动去除前导零
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0); //没有写出来的默认是0
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }

}
