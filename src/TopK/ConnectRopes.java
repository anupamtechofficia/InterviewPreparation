package TopK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectRopes {

    static Integer connectRopes(int[] numbers){
        if(numbers.length == 1) return numbers[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>( numbers.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? 1 : -1;
            }
        });
        for (int k =0; k < numbers.length ; k++){
            pq.add(numbers[k]);
        }
        int sum = 0;

        while (!pq.isEmpty() && pq.size()>1){
            int rope1 = pq.poll();
            int repe2 = pq.poll();
            sum += rope1 + repe2;
            pq.add(rope1 + repe2);

        }
        pq.poll();
        return sum;

    }


    public static void main(String ... s){
        int[] a = {1, 3, 11, 5};
        System.out.println(connectRopes(a));
    }


}
