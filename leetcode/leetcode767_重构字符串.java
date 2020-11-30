import java.util.*;

public class leetcode767_重构字符串 {
    public String reorganizeString(String S) {
        if (S.length()<2){
            return S;
        }
        int[] counts=new int[26];
        int maxCount=0;
        int length = S.length();
        for (int i = 0; i <length ; i++) {
            char c=S.charAt(i);
            counts[c-'a']++;
            maxCount=Math.max(maxCount,counts[c-'a']);
        }
        if (maxCount>(length+1)/2){
            return "";
        }
        //优先队列，最大堆，降序
        PriorityQueue<Character> queue=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(queue.size()>1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            while(counts[index1]>0 &&counts[index2]>0){
                sb.append(letter1);
                sb.append(letter2);
                counts[index1]--;
                counts[index2]--;
            }
            if (counts[index1]>0) queue.offer(letter1);
            if (counts[index2]>0) queue.offer(letter2);
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new leetcode767_重构字符串().reorganizeString("aaababaacbb")
        );
    }
}
