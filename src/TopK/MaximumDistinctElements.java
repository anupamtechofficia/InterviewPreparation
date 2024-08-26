package TopK;

import java.util.*;

public class MaximumDistinctElements {

    static Integer maximumDistinctElements(int[] numbers, int K){
        Integer result = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0;i< numbers.length;i++){
            count.put(numbers[i] , count.getOrDefault(numbers[i], 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>( K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]>o2[1] ? 1 : -1;
            }
        });
        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue()>1){
                int[] duplicates = new int[2];
                duplicates[0] = entry.getKey();
                duplicates[1] = entry.getValue();
                pq.add(duplicates);
            } else {
                result++;
            }
        }
        int allowDelete = K;
        while (!pq.isEmpty() && allowDelete>0){
            int[] peek = pq.poll();
            if((peek[1]-1)>allowDelete){
                allowDelete = 0;
            } else {
                allowDelete -= (peek[1]-1);
                result++;
            }

        }

        result-=allowDelete;

        return result;

    }


    public static void main(String ... s){
        int[] a = {1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5};
        System.out.println(maximumDistinctElements(a, 2));
        int[] b = {3, 5, 12, 11, 12};
        System.out.println(maximumDistinctElements(b, 3));
    }
}
