package TopK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {

    static List<Integer> getTopKNumbers(int[] numbers, int K){
        List<Integer> topK = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>( K, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? 1 : -1;
            }
        });
        for (int k =0; k <K ; k++){
                pq.add(numbers[k]);
        }

        for (int k =K; k < numbers.length ; k++){
            if(numbers[k] >= pq.peek()){
                pq.poll();
                pq.add(numbers[k]);
            }
        }

        for (Integer top : pq){
            topK.add(top);
        }

        return topK;

    }


    public static void main(String ... s){
        int[] a = {3, 1, 5, 12, 2, 11};
        int K = 3;
        System.out.println(getTopKNumbers(a, K));
    }
}
