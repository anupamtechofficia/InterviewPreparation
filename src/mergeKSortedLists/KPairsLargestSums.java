package mergeKSortedLists;

import java.util.*;

import static java.util.Map.entry;

public class KPairsLargestSums {

    static List<List<Integer>> sort(int[] list1, int[] list2 , int k){

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getKey() + o1.getValue()) > (o2.getKey() + o2.getValue()) ? 1: -1;
            }
        });

        int i = 0, j= 0;

        while (i< list1.length && j<list2.length ){
            Map.Entry<Integer, Integer> top = queue.peek();
            boolean added = false;
            if(top == null || queue.size() < k ||(list1[i] + list2[j]) > (top.getKey() + top.getValue())){
                if(top!=null && queue.size() >k) queue.poll();
                queue.add(entry(list1[i], list2[j]));
                added = true;
            }
            if(top == null || queue.size() < k || (i+1 < list1.length && (list1[i+1] + list2[j])
                    > (top.getKey() + top.getValue()))){
                if(top!=null && queue.size() >k) queue.poll();
                queue.add(entry(list1[i+1], list2[j]));
                added = true;
            }
            if(top == null || queue.size() < k || ( j+1 < list2.length && (list1[i] + list2[j+1]) >
                    (top.getKey() + top.getValue()))){
                if(top!=null && queue.size() >k) queue.poll();
                queue.add(entry(list1[i], list2[j+1]));
                added = true;
            }
            if(!added) break;
            i++;
            j++;
        }
        for (Map.Entry<Integer,Integer> e : queue){
            List<Integer> pair = new ArrayList<>(2);
            pair.add(e.getKey());
            pair.add(e.getValue());
            ans.add(pair);
        }
        return ans;

    }

    public static void main(String ... s){
        int[] test11 = {9, 8, 2};
        int[] test22 = {6, 3, 1};
        System.out.println(sort(test11, test22, 3));
        int[] test1 = {5,2,1};
        int[] test12 = {2,-1};
        System.out.println(sort(test1, test12, 3));
    }
}
