import java.util.*;

public class interview0809 {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,0,"",n);
        return res;
    }
    public void helper(int left,int right,String cur,int n) {
        if(left<0||right<0||left>n||right>n) return;
        if(left==0 && right==0) res.add(cur);
        if(left>0) helper(left-1,right+1,cur+"(",n); //
        if(right>0) helper(left,right-1,cur+")",n);
    }

    public static void main(String[] args) {
        new interview0809().generateParenthesis(3);
    }
}
