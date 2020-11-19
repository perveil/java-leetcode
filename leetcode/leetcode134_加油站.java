public class leetcode134_加油站 {
    public static void main(String[] args) {
        System.out.println(
            new leetcode134_加油站().canCompleteCircuit(new int[]{
                    3,1,1
            },new int[]{
                    1,2,2
            })
        );
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i <gas.length ; i++) {  //从i开始
            int allGas=0; //所有的汽油，初始为0
            for (int j = i; j <=gas.length ; j++) {
                if (j==gas.length){ //从环路末尾出发，到达环路起点，从起点继续走
                    if (i==0&&allGas>=0) return i; //如果起点是0，那么此时就已经饶了一圈
                    for (int k = 0; k <i; k++) {
                        allGas+=gas[k]-cost[k];
                        if (allGas<0) break;
                        if (k==i-1&&allGas>=0) return i;
                    }
                }
                if (j<gas.length){ //没有到达环路终点，先到环路终点
                    allGas+=gas[j]-cost[j];
                    if (allGas<0) break;
                }
            }
        }
        return -1;
    }
}
