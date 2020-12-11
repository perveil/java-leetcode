import java.util.*;

public class leetcode399_除法求值 {
    /*
    * equations 中的equation[i]可以进行一下操作：
    * 1.乘法  equation[i]*equation[j]
    * 2.除法 equation[i]/equation[j]=equation[i]* 1/equation[j]
    * 3.取倒数 1/ equation[i]
    *
    * [["a","c"],["b","d"]] [5.0,2.0] [["ad","cb"]] 答案是[-1.000] 说明分子和分母不存在合并的情况
    *
    *  a/c存在三种情况
    *   1. a/b * b/c
    *   2. (a/b) / (c/b)  = (a/b) *  (1/(c/b))
    *   3. 1/(c/a)
    * */
    Set<String> partArray=new HashSet<>(); //equations中的分子分母集合，用于在queries判断分子分母是否存在
    Map<String,List<String>> fenziTofenmuMap=new HashMap<>();// <Key,Value> key是分子、Value是分母的集合
    Map<String,Double> equationsMap=new HashMap<>(); // <Key,Value> key是分母与分子的拼接、equation的值
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res=new double[queries.size()];
        int i=0;
        for (List<String> list: equations) {
            String fenzi=list.get(0);
            String fenmu=list.get(1);
            partArray.add(fenzi);
            partArray.add(fenmu);
            if (fenziTofenmuMap.get(fenzi)==null) fenziTofenmuMap.put(fenzi,new ArrayList<>());
            if (fenziTofenmuMap.get(fenmu)==null) fenziTofenmuMap.put(fenmu,new ArrayList<>());
            fenziTofenmuMap.get(fenzi).add(fenmu);
            fenziTofenmuMap.get(fenmu).add(fenzi);
            equationsMap.put(fenzi+fenmu,values[i++]);
            equationsMap.put(fenmu+fenzi,1/values[i++]);
        }
        i=0;
        for (List<String> query: queries) {
            String fenzi=query.get(0);
            String fenmu=query.get(1);
            //不存在
            if (!partArray.contains(fenmu)||!partArray.contains(fenzi)){
                res[i++]=-1.000;
                continue;
            }
            //情况3
            if (equationsMap.containsKey(fenmu+fenzi)){
                res[i++]=1/equationsMap.get(fenzi+fenmu);
                continue;
            }
            //情况1 graph.dfs
            Map<String,Boolean> markedMap=new HashMap<>();// <Key,Value> key是分子、Value是分母的集合
            Double d= dfs(fenzi,fenmu,markedMap);
            if (d!=0){
                res[i++]=d;
            }
            //情况2 ，转换成情况1
        }
        return res;
    }
    public  double dfs(String start,String end,Map<String,Boolean> marked){
        if (marked.get(start)){ //已经访问过了start
            return  0.00;
        }
        if (start.equals(end)){ //找到了目标值
            return 1.00;
        }
        marked.put(start,true);
        for (String temp:fenziTofenmuMap.get(start)) {
            double d=dfs(temp,end,marked);
            if (d!=0){
                return equationsMap.get(start+temp)*dfs(temp,end,marked);
            }
        }
        return 1.00;
    }
}
