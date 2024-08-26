package TopK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestNumbers {


    static List<Integer> kClosestNumbers(int[] numbers, int k , int x){
        List<Integer> ans = new ArrayList<Integer>();
        if(numbers == null || numbers.length == 0) return ans;


        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff1 = Math.abs(o1[0] - o1[1]);
                int diff2 = Math.abs(o2[0] - o2[1]);
                return diff1 > diff2 ? -1 : 1;
            }
        });

        for (int i = 0;i< k ;i++){
            int[] num = new int[2];
            num[0] = numbers[i];
            num[1] = x;
            maxHeap.add(num);
        }
        for (int i = k;i < numbers.length ;i++){
            int diff = Math.abs(numbers[i] - x);
            int[] peak = maxHeap.peek();
            int diff1 = Math.abs(peak[0] - x);
            if(diff<= diff1){
                maxHeap.poll();
                int[] num = new int[2];
                num[0] = numbers[i];
                num[1] = x;
                maxHeap.add(num);
            }
        }
        for (int[] d: maxHeap){
            ans.add(d[0]);
        }
        return ans;

    }


    public static void main(String ... s){
        int[] a = {5, 6, 7, 8, 9};
        System.out.println(kClosestNumbers(a, 3, 7));
    }

}
