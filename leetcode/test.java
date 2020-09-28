import java.util.*;

public class test {
    public static void main(String[] args) {
        //输入输出
//        Scanner reader = new Scanner(System.in) ;
//        while(reader.hasNext())
//        {
//            int m = reader.nextInt() ;
//            int [] numbers = new int[m] ;
//            for(int index=0;index<m;index++)
//            {
//                numbers[index] = reader.nextInt();
//            }
//            System.out.println(Arrays.toString(numbers));
//        }
          //String
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        List<Integer> list=new ArrayList<>(queue);
        System.out.println(list.get(0));
    }
}
