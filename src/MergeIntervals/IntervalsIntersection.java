package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

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

    public static List<Intervals> intervalsIntersection(Intervals[] input, Intervals[] newIntervals){;
        List<Intervals> result = new ArrayList<>();
        int i=0 , j = 0;
        while (i<input.length && j<newIntervals.length){
            if(newIntervals[j].start> input[i].end){
                i++;
            }else if(input[i].start>newIntervals[j].end){
                j++;
            } else {
                result.add(new Intervals(Math.max(input[i].start, newIntervals[j].start),
                        Math.min(input[i].end, newIntervals[j].end)));
                if(input[i].end> newIntervals[j].end){
                    j++;
                } else if (input[i].end < newIntervals[j].end){
                    i++;
                }  else{
                  i++;
                  j++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Intervals[] arr = {new Intervals(1, 3), new Intervals(5, 6), new Intervals(7, 9)};
        Intervals[] arr1 = {new Intervals(2, 3), new Intervals(5, 6), new Intervals(7, 7)};
        System.out.println(intervalsIntersection(arr, arr1).toString());

        Intervals[] arr11 = {new Intervals(1, 3), new Intervals(5, 7), new Intervals(9, 12)};
        Intervals[] arr12 = {new Intervals(5, 10)};
        System.out.println(intervalsIntersection(arr11, arr12).toString());
    }
}
