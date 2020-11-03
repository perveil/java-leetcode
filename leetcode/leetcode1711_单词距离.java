import java.util.*;

public class leetcode1711_单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        if(word1.equals(word2)) return 0;
        int start = -1;
        int end = words.length;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                start = i;
            }
            if (words[i].equals(word2)) {
                end = i;
            }
            min = Math.min(min, Math.abs(end-start));
        }
        return min;
    }
}
