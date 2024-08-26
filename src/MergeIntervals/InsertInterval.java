package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
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

    public static List<Intervals> insertAndMergeInterval(Intervals[] input, Intervals newIntervals){;
        Intervals[] arr = new Intervals[input.length +1];
        int index = 0;
        boolean newIntervalAdded = false;
        for (int i = 0;i< input.length;i++){
            if(!newIntervalAdded && input[i].start > newIntervals.start){
                arr[index++] = newIntervals;
                newIntervalAdded = true;
            }
            arr[index++] = input[i];
        }
        List<Intervals> result = new ArrayList<>();
        int  currentStart = arr[0].start;
        int  currentEnd = arr[0].end;
        for (int i =1 ;i< arr.length;i++){
            if(newIntervals.start <= currentEnd && newIntervals.start>=currentStart){
                currentEnd = Math.max(currentEnd, newIntervals.end);
            }
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

    public static List<Intervals> insertAndMergeInterval1(Intervals[] input, Intervals newIntervals){;
        List<Intervals> result = new ArrayList<>();
        int index= 0;
        while (index < input.length && input[index].end< newIntervals.start){
            result.add(input[index++]);
        }
        int currentStart = newIntervals.start ;
        int currentEnd = newIntervals.end ;
        while (index < input.length &&
                ((input[index].start<=currentStart && input[index].end>=currentStart)
                        ||(currentStart<= input[index].start && currentEnd>=input[index].start))){
            currentStart = Math.min(currentStart, input[index].start);
            currentEnd = Math.max(currentEnd, input[index].end);
            index++;
        }
        result.add(new Intervals(currentStart, currentEnd));

        while (index<input.length){
            result.add(input[index++]);
        }
        return result;

    }

    public static void main(String[] args) {
        Intervals[] arr = {new Intervals(1, 3), new Intervals(5, 7), new Intervals(8, 12)};
        System.out.println(insertAndMergeInterval1(arr, new Intervals(4, 6)).toString());
        Intervals[] arr1 = {new Intervals(1, 3), new Intervals(5, 7), new Intervals(8, 12)};
        System.out.println(insertAndMergeInterval1(arr1, new Intervals(4, 10)).toString());
        Intervals[] arr2 = {new Intervals(2, 3), new Intervals(5, 7)};
        System.out.println(insertAndMergeInterval1(arr2, new Intervals(1, 4)).toString());
    }
}
