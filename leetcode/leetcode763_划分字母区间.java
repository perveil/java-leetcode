import java.util.*;

public class leetcode763_划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        Map<Character,ArrayList<Integer>> ch2List=new HashMap<>();
        char [] chars=S.toCharArray();
        for(int i=0;i<chars.length;i++){ //统计当前字符
            if(!ch2List.containsKey(chars[i])){
                ch2List.put(chars[i],new ArrayList<Integer>());
            }
            ch2List.get(chars[i]).add(i);
        }
        int start = -1,end =-1;
        for (int i=0; i <S.length() &&start<=end ;i++) {
            char ch=chars[i];
            int ch_gap_start=ch2List.get(ch).get(0);
            if (start==-1) start=ch_gap_start;
            int size=ch2List.get(ch).size();
            int ch_gap_end=size>1?ch2List.get(ch).get(size-1):-1;
            if (end==-1) end=ch_gap_end;

            if (start<ch_gap_start&&ch_gap_end>end) end=ch_gap_end;
            if (i==end+1){
                res.add(end-start+1);
                start=i;
                end=-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
