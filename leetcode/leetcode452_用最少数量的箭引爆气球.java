import java.util.*;

public class leetcode452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if(points.length<=1) return  points.length;
        //依据圆直径左测点排序，左测点相等的时候比较右侧点
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int len=points.length;
        Stack<int[]> stack=new Stack<>(); //合并
        stack.add(points[0]);
        for (int i = 1; i <len; i++) {
            int[] node=stack.peek();
            if (points[i][0] <= node[1]){
                stack.pop();
                stack.add(new int[]{Math.max(points[i][0],node[0]),Math.min(node[1],points[i][0])});
            }else{  //此时无法合并，加入已合并完成的元素
                stack.add(points[i]);
            }
        }
        return  stack.size();
    }

    public static void main(String[] args) {
        new leetcode452_用最少数量的箭引爆气球().findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});
    }
}
