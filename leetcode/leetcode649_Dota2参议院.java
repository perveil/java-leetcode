import java.util.*;

public class leetcode649_Dota2参议院 {
//    //谁在前边，谁就更早发动技能，谁就有主动权
//    public String predictPartyVictory(String senate) {
//        Queue<Integer> radiant = new LinkedList<>(); //radiant
//        Queue<Integer> dire = new LinkedList<>();
//        int n=senate.length();
//        for (int i = 0; i <n ; i++) {
//            if (senate.charAt(i)=='R'){
//                radiant.add(i);
//            }else {
//                dire.add(i);
//            }
//        }
//        while (!radiant.isEmpty()&&!dire.isEmpty()){
//            int r=radiant.poll();
//            int d=dire.poll();
//            if (r<d){ //r在前边，r有主动权，可以废掉d，废掉d之后，r还得再进队列中，但是就是下一轮了
//                radiant.add(r+n);
//            }else{ //d在前边，d有主动权，可以废掉r
//                dire.add(d+n);
//            }
//        }
//        return radiant.isEmpty()?"Dire":"Radiant";
//    }
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>(); //radiant
        Queue<Integer> dire = new LinkedList<>();
        int n=senate.length();
        for (int i = 0; i <n ; i++) {
            if (senate.charAt(i)=='R'){
                radiant.add(i);
            }else {
                dire.add(i);
            }
        }
        boolean [] seen=new boolean[n];
        while(!dire.isEmpty()&&!radiant.isEmpty()){ //多轮
            for (int i = 0; i <n ; i++) {
                if (!seen[i]&&senate.charAt(i)=='R'){
                    if (!dire.isEmpty()) seen[dire.poll()]=true;
                    else return "Radiant";
                }
                else if(!seen[i]&&senate.charAt(i)=='D'){
                    if (!radiant.isEmpty()) seen[radiant.poll()]=true;
                    else return "Dire";
                }else{
                    continue;
                }
            }
        }
        return radiant.isEmpty()?"Dire":"Radiant";
    }

    public static void main(String[] args) {
        new leetcode649_Dota2参议院().predictPartyVictory("DRRDRDRDRDDRDRDR");
    }
}
