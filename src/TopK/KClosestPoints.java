package TopK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {


    static List<List<Integer>> getTopKNumbers(int[][] points, int K){
        List<List<Integer>> topK = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int distance1 = o1[0]*o1[0] +  o1[1]*o1[1];
                int distance2 = o2[0]*o2[0] +  o2[1]*o2[1];
                return distance1>distance2 ? -1 : 1;
            }
        });
        for (int k =0; k <K ; k++){
            pq.add(points[k]);
        }

        for (int k =K; k < points.length ; k++){
            int distance1 = points[k][0]*points[k][0] + points[k][1]*points[k][1];
            int maxPeek = pq.peek()[0]*pq.peek()[0] + pq.peek()[1]*pq.peek()[1];
            if(distance1 <= maxPeek){
                pq.poll();
                pq.add(points[k]);
            }
        }

        for (int[] top : pq){
            List<Integer> temp = new ArrayList();
            temp.add(top[0]);
            temp.add(top[1]);
            topK.add(temp);
        }

        return topK;

    }


    public static void main(String ... s){
        int[][] a = {{1, 3}, {3, 4}, {2, -1}};
        int K = 2;
        System.out.println(getTopKNumbers(a, K));
    }
}
