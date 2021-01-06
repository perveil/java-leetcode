package graph.dfs;
/*
  @Date:2021/1/6 9:48
  @Author:Administrator
*/

import java.util.*;

public class leetcode399_除法求值 {
    Map<String,List<String>> graph=new HashMap<>();
    Map<String,Double> weights=new HashMap();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res=new double[queries.size()];
        int n=0;
        int size=equations.size();
        for (int i=0;i<size;i++) {
            List<String> s=equations.get(i);
            String str1=s.get(0); //分子
            String str2=s.get(1); //分母
            if (!graph.containsKey(str1)) graph.put(str1,new ArrayList<>());
            if (!graph.containsKey(str2)) graph.put(str2,new ArrayList<>());
            weights.put(str1+"+"+str2,values[i]);
            weights.put(str2+"+"+str1,1/values[i]);
        }
        List<String> visited=new ArrayList<>();
        for (List<String> s:queries) {
            double tmp = dfs(s.get(0),s.get(1), visited);
            if(tmp == 0){
                tmp = -1.0;
            }
            res[n++]=tmp;
        }
        return res;
    }
    public double dfs(String start,String end,List<String> visited){
        if (weights.containsKey(start+"+"+end)){
            return weights.get(start+"+"+end);
        }
        if (!graph.containsKey(start)||!graph.containsKey(end)){
            return 0;
        }
        if (visited.contains(start)||visited.contains(end)){
            return 0;
        }
        visited.add(start);
        double res=0;
        for (String next:graph.get(start)) {
            res=dfs(next,end,visited);
            if (res!=0){
                weights.put(next+"+"+end,res);
                break;
            }
        }
        visited.remove(start);
        return res;
    }
}
