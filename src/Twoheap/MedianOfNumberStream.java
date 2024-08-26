package Twoheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfNumberStream {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2 ? 1:-1;
        }
    });
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2 ? -1:1;
        }
    });


    public static void insert(int number){
        if(maxHeap.size()==0){
            maxHeap.add(number);
            return;
        }
        if(minHeap.size()==0){
            minHeap.add(number);
            return;
        }
        int removeNumber = 0;
      if(number <= maxHeap.peek()){
          removeNumber = maxHeap.poll();
          maxHeap.add(number);
      } else {
          removeNumber = minHeap.poll();
          minHeap.add(number);
      }
      if(minHeap.size()<maxHeap.size()){
          minHeap.add(removeNumber);
      } else {
          maxHeap.add(removeNumber);
      }
    }

    public static double getMedian(){
        if(maxHeap.size() == minHeap.size()){
            double x = ((double)(maxHeap.peek() + minHeap.peek()))/2;
            return  x;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String ... args){
        insert(3);
        insert(1);
        System.out.println(getMedian());
        insert(5);
        System.out.println(getMedian());
        insert(4);
        System.out.println(getMedian());


    }
}
