package tree.前缀树;/*
  @Date:2020/12/23 21:41
  @Author:Administrator
*/

import java.util.*;
class WordDictionary {
    private final int AlPHA_SIZE=26;
    private WordDictionary[] child=new WordDictionary[AlPHA_SIZE];
    boolean isEndOFWord=false;
    /** Initialize your data structure here. */
    public WordDictionary() { }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary temp=this;
        for (char c: word.toCharArray()) {
            if (temp.child[c-'a']==null){  //c不在tmp的子节点中
                temp.child[c-'a']=new WordDictionary();
            }
            temp=temp.child[c-'a'];
        }
        temp.isEndOFWord=true; //temp已经到了word的最后一个字符
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(this,word,0);
    }
    public boolean dfs(WordDictionary node, String word, int index){
        if(index >= word.length()){
            return node.isEndOFWord;
        }
        char curLetter=word.charAt(index);
        if(curLetter!='.'){
            if(node.child[curLetter - 'a'] != null){
                return dfs(node.child[curLetter - 'a'],word,index+1);
            }
            return false;
        }
        //curLetter=='.',直接遍历下一层节点
        for (WordDictionary dic: node.child) {
            if (null!=dic && dfs(dic,word,index+1)){
                return true;
            }
        }
        return  false;
    }
}
public class leetcode211_添加与搜索单词 {

}
