package TopK;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.Map.entry;

public class RearrangeStringKDistance {

    static String schedulingTasks(String str, int K) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            count.put(str.charAt(i)+ ",0",count.getOrDefault(str.charAt(i)+ ",0",0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(count.size(), new Comparator<
                Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int waitTime1 = Integer.parseInt(o1.getKey().split(",")[1]);
                int waitTime2 = Integer.parseInt(o2.getKey().split(",")[1]);
                if(waitTime1 == waitTime2){
                    return o1.getValue() > o2.getValue() ? -1 : 1;
                }
                return waitTime1 > waitTime2  ? 1 : -1;
            }
        });
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            pq.add(entry);
        }
        StringBuilder abc = new StringBuilder();
        int result = 0;
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            Integer waitTime = Integer.parseInt(entry.getKey().split(",")[1]);
            if(waitTime > result) {
                abc = new StringBuilder("");
                return abc.toString();
            }
            result++;
            abc.append(entry.getKey().split(",")[0]);
            if(entry.getValue()>1){
                String newkey = entry.getKey().split(",")[0] + "," + (result+K-1);
                pq.add(entry(newkey, entry.getValue()-1));
            }

        }
        return abc.toString();

    }


    public static void main(String... s) {
        System.out.println(schedulingTasks("mmpp", 2));
        System.out.println(schedulingTasks("Programming", 3));
        System.out.println(schedulingTasks("aab", 2));
        System.out.println(schedulingTasks("aappa", 3));
        System.out.println(schedulingTasks("aappa", 2));

    }
}
