package dfs;

import java.util.*;

public class leetcode126_单词路径 {
    List<List<String>> minLenPaths =new LinkedList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord)==-1) return minLenPaths;
        Map<String,List<String>> neborMap=new HashMap<>(); //此无向无权图的邻接表
        HashMap<String, Boolean> visited = new HashMap<>();
        List<String> similarWordList=similarWordList(beginWord,wordList); //获得beginWord 所有nextword
        neborMap.put(beginWord,similarWordList);
        visited.put(beginWord,false);
        for (String s:wordList) {
            neborMap.put(s,similarWordList(s,wordList));
            visited.put(s,false);
        }
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        dist.put(beginWord,1);
        int len=bfs(beginWord,endWord,neborMap,dist);
        /*
        * dfs findPaths
        * */

        List<String> path=new LinkedList<>();
        visited.put(beginWord,true);
        path.add(beginWord);
        dfs_path(beginWord,endWord,neborMap,visited,len,1,path);
        return minLenPaths;

    }
    /*
    *  param:
    *   beginWord: 开始字符串
    *   wordList:  需要比较的字符串
    * */
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
            if (nums>=2) return false;
        }
        return nums==1;
    }
    public int bfs(String beginWord, String endWord, Map<String,List<String>> neborMap,HashMap<String, Integer> dist) {
        Queue<String> queue = new LinkedList<String>(); //队列
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String top=queue.poll(); //取出队首元素
            int d = dist.get(top) + 1;  //得出其周边还未被访问的节点的距离
            for (String c : neborMap.get(top)) {
                if (!dist.containsKey(c)){  //此元素未访问
                     if (c==endWord)  return d; //找到endWord
                     dist.put(c, d);
                     queue.add(c);
                }
            }
        }
        return 0;
    }
    /*
    * leetcode 126 dfs 寻找路径长度为len的路径
    * */
    public void dfs_path(String beginWord, String endWord, Map<String,List<String>> neborMap,HashMap<String, Boolean> visited,int len,int curlen,List<String> path) {
        if (beginWord.equals(endWord) && curlen==len){
            minLenPaths.add(new ArrayList<>(path));
            return;
        }
        for (String s: neborMap.get(beginWord)) {
            if (visited.get(s)) continue; //已访问过，直接跳过
            visited.put(s,true);
            path.add(s);
            dfs_path(s,endWord,neborMap,visited,len,curlen+1,path);  //递归
            visited.put(s,false);  //回溯
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        String []strs= new String[]{
                "hot","dot","dog","lot","log","cog"
        };
        List<String> list=new ArrayList<>();
        for (String s: strs) {
            list.add(s);
        }
      new leetcode126_单词路径().findLadders("hit","cog", list);


    }
}
