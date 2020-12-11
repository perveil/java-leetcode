package graph.bfs;/*
  @Date:2020/11/5 9:27
  @Author:Administrator
*/

import java.util.*;

public class leetcode127_单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord)==-1) return 0;
        Map<String,List<String>> neborMap=new HashMap<>(); //此无向无权图的邻接表，key：单词，value：和key相差一个字符的单词
        List<String> similarWordList=similarWordList(beginWord,wordList); //获得beginWord 所有nextword
        neborMap.put(beginWord,similarWordList);
        for (String s:wordList) {
            neborMap.put(s,similarWordList(s,wordList));
        }
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        dist.put(beginWord,1);
        int len=bfs(beginWord,endWord,neborMap,dist); //graph.bfs 求最短距离
        return len;
    }
    public List<String> similarWordList(String beginWord, List<String> wordList) {
        List<String> similarList=new ArrayList<>();
        for (String s:
                wordList) {
            if (isSimilar(beginWord,s)) similarList.add(s);
        }
        return similarList;
    }
    public boolean isSimilar(String beginWord, String endWord) {
        int nums=0; //beginWord、endWord 不相同的位置
        for (int i = 0; i <beginWord.length(); i++) {
            if (beginWord.charAt(i)!=endWord.charAt(i))
                nums++;
        }
        return nums==1;
    }
    public int bfs(String beginWord, String endWord, Map<String,List<String>> neborMap,HashMap<String, Integer> dist) {
        Queue<String> queue = new LinkedList<>(); //队列
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String top=queue.poll(); //取出队首元素
            int d = dist.get(top) + 1;  //得出其周边还未被访问的节点的距离
            for (String c : neborMap.get(top)) {
                if (!dist.containsKey(c)){  //此元素未访问
                    if (c.equals(endWord))  return d; //找到endWord
                    dist.put(c, d);
                    queue.add(c);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String []strs= new String[]{
                "hot","dot","dog","lot","log","cog"
        };
        List<String> list=new ArrayList<>();
        for (String s: strs) {
            list.add(s);
        }
        int minlength=new leetcode127_单词接龙().ladderLength("hit","cog",list);
    }
}
