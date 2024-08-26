package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static class Intervals implements Comparable<Intervals>{
        public int start;
        public int end;


        Intervals(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Intervals o) {
            if(o.start== this.start) return 0;
            if (o.start > this.start) return -1;
            else return 1;
        }

        @Override
        public String toString() {
            return "Intervals{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static List<Intervals> mergeIntervals(Intervals[] arr){
        Arrays.sort(arr);
        List<Intervals> result = new ArrayList<>();
        int  currentStart = arr[0].start;
        int  currentEnd = arr[0].end;;

        for (int i =1 ;i< arr.length;i++){
            if (arr[i].start <= currentEnd && arr[i].start>=currentStart){
                currentEnd = Math.max(currentEnd, arr[i].end);
            } else {
                result.add(new Intervals(currentStart, currentEnd));
                currentStart = arr[i].start;
                currentEnd = arr[i].end;
            }
        }
        result.add(new Intervals(currentStart, currentEnd));
        return result;

    }

    public static void main(String[] args) {
        Intervals[] arr = {new Intervals(1, 4), new Intervals(2, 5), new Intervals(7, 9)};
        System.out.println(mergeIntervals(arr).toString());
        Intervals[] arr1 = {new Intervals(6, 7), new Intervals(2, 4), new Intervals(5, 9)};
        System.out.println(mergeIntervals(arr1).toString());
        Intervals[] arr2 = {new Intervals(1, 4), new Intervals(2, 6), new Intervals(3, 5)};
        System.out.println(mergeIntervals(arr2).toString());
    }
}
