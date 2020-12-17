import java.util.*;

public class leetcode784_字母大小写全排列 {
    // 问题转换成：字母索引的全排列的，然后选取索引排列中的字母，将其变成大写,其余的变成小写
    List<List<Integer>> permutationCharIndexList=new ArrayList<>();
    List<String> res=new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        S=S.toLowerCase();
        List<Integer> charIndexList=new ArrayList<>();
        for (int i=0;i<S.length();i++) {
            if ((int)S.charAt(i)>57){ //字母
                charIndexList.add(i);
            }
        }
        int indexs[]=new int[charIndexList.size()]; //问题转化成indexs 的所有全排列
        int i=0;
        for (int x: charIndexList) {
            indexs[i++]=x;
        }
        helper(indexs,new LinkedList<>(),charIndexList.size(),0);
        for(List<Integer> indexlist:permutationCharIndexList){ //遍历索引的排列组合
            res.add(helperOfUpper(indexlist,S));
        }
        return res;
    }
    public String helperOfUpper(List<Integer> indexlist,String S){
        if (indexlist.size()==0) return S;
        StringBuilder s=new StringBuilder();
        int j=0;
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if (indexlist.contains(i)){
                c=Character.toUpperCase(c);
            }else{
                c=Character.toLowerCase(c);
            }
            s.append(c);
        }
        return s.toString();
    }
    public void helper(int [] indexs,List<Integer> cur,int len,int start) {
        if (cur.size()==len){ //递归结束条件
            permutationCharIndexList.add(new ArrayList<>(cur));
            return;
        }
        permutationCharIndexList.add(new ArrayList<>(cur));
        for (int i = start; i <indexs.length; i++) {
            cur.add(indexs[i]);
            helper(indexs,cur,len,i+1);
            cur.remove(cur.size()-1); //回溯
        }
    }

    public static void main(String[] args) {
       new leetcode784_字母大小写全排列().letterCasePermutation("C");
    }
}
