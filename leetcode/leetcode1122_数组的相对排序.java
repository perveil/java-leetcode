import java.util.*;

public class leetcode1122_数组的相对排序 {
    static  class Node{
        int index;
        int num;
        public Node(int index,int num){
            this.index=index;
            this.num=num;
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <arr2.length; i++) {
            map.put(arr2[i],i);
        }
        Node [] nodes=new Node[arr1.length];
        for (int i = 0; i <arr1.length; i++) {
            nodes[i]=new Node(map.getOrDefault(arr1[i],arr2.length),arr1[i]);
        }
        Arrays.sort(nodes,(n1,n2)->{
            if ((n1.index==n2.index)&&n1.index==arr2.length){ //arr2中没出现的，按大小依次排序
                return n1.num-n2.num;
            }
            return n1.index-n2.index;
        });
        int res[]=new int[arr1.length];
        for (int i = 0; i <arr1.length ; i++) {
            res[i]=nodes[i].num;
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode1122_数组的相对排序().relativeSortArray(new int[]{
                22,28,8,6,44,17
        },new int[]{
                22,28,8,6
        });
    }
}
