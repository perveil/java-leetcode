import java.util.*;

public class interview0808_有重复字符的排列组合 {
    //转换为有重复数字的全排列
    List<List<Integer>> result =new ArrayList<>();
    public String[] permutation(String S) {
        int [] nums=new int[S.length()];
        int len=S.length();
        for (int i = 0; i <len; i++) {
            nums[i]=S.charAt(i);
        }
        perm(result,nums,0,nums.length-1);
        int size=result.size();
        int i=0;
        String [] res=new String[size];
        for (List<Integer> l:result) {
            StringBuilder s=new StringBuilder();
            for (int c: l) {
                s.append((char)c);
            }
            res[i++]=s.reverse().toString();
        }
        return res;
    }
    public void perm(List<List<Integer>> result,int[] aim,int k,int m) {
        if (k==m){
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<=m;i++){
                list.add(aim[i]);
            }
            result.add(list);
        }else{
            for (int i=k;i<=m;i++){
                if (isSwap(aim,k,i)){
                    swap(aim,k,i);
                    perm(result,aim, k+1, m);
                    swap(aim,k,i); //回溯，专注于交换子列表的第一个数字
                }
            }
        }
    }
    public  void swap(int [] aim,int k,int m){
        int temp=aim[m];
        aim[m]=aim[k];
        aim[k]=temp;
    }
    public  boolean isSwap(int [] aim,int k,int m){
        for(int index = k;index<m;index++)
        {
            if(aim[index]==aim[m])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new interview0808_有重复字符的排列组合().permutation("qqe");
    }
}
