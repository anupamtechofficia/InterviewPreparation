package mergeKSortedLists;

import java.util.*;

import static java.util.Map.entry;

public class MergeKSortedLists {


    static List<Integer> sort(int[][] sortedArrays){
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, String>> queue = new PriorityQueue<>(sortedArrays.length, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey()> o2.getKey() ? 1: -1;
            }
        });
        queue.add(entry(sortedArrays[0][0], "0,0"));
        queue.add(entry(sortedArrays[1][0], "1,0"));
        queue.add(entry(sortedArrays[2][0], "2,0"));
        while (!queue.isEmpty()){
            Map.Entry<Integer, String>  top = queue.poll();
            ans.add(top.getKey());
            int arrayNumber = Integer.parseInt(top.getValue().split(",")[0]);
            int arrayIndex = Integer.parseInt(top.getValue().split(",")[1]);
            if(arrayIndex+1 < sortedArrays[arrayNumber].length){
                queue.add(entry(sortedArrays[arrayNumber][arrayIndex+1], arrayNumber + "," + (arrayIndex+1)));
            }
        }
        return ans;

    }

    public static void main(String ... s){
        int[][] test = {{2, 6, 8},{3, 6, 7},{1, 3, 4}};
        System.out.println(sort(test));
    }
}
