package sort.bucketsort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 题解：https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
* 关键：列优先分配
* */
public class leetcode621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26]; //字符计数
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);//0 到了前边，出现了的字符到后边
        /*
        *  某任务出现的最大次数为分配桶的个数
        *  初始桶的大小：n+1，为什么是n+1 是为了长度为n的缓冲时间
        *  idle_slots=max_val*n 为在填充完出现最多次数的某任务之后的代填充时间
        *  将最频繁出现的任务安插到每个桶之后，每个桶剩下的代填充时间为n，一共有max_val*n长的代填充时间
        *
        * */
        int max_val=map[25]-1,idle_slots=max_val*n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) { // 遍历剩下的任务
            idle_slots-=Math.min(map[i], max_val);
            /*
            * Math.min(map[i], max_val) 为 map[i] 所对应字符运行所占的空闲时间
            * */
        }
        return idle_slots>0?idle_slots+tasks.length:tasks.length;
        // idle_slots<0 说明预定的max_val*n的桶大小已经不够容纳所有的任务，桶里的任务也都满足n大小的缓冲时间
        //此时为了安置剩下的任务，桶需要扩容！扩容之后的运行时间要等于总任务的长度，因为没有空闲时间
    }
}
