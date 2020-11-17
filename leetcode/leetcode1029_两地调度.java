import java.util.*;

public class leetcode1029_两地调度 {
    //比较i人 去A不去B（costs[i][1]-costs[i][0]），去B不去A(costs[i][0]-costs[i][1]
    //假设2n人全去A，选出去B比A省钱最多n个人，此时，去An个人，去Bn个人
    public int twoCitySchedCost(int[][] costs) {
        int res=0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for (int[] arr:costs) {
            res+=arr[0]; //直接去A城
            q.add(arr[1]-arr[0]);
        }
        for (int i = 0; i <costs.length/2; i++) {
            res+=q.poll();
        }
        return res;
    }
}
