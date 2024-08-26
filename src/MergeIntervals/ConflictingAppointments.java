package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConflictingAppointments {

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

    public static boolean conflictingAppointments(Intervals[] arr){
        Arrays.sort(arr);
        List<Intervals> result = new ArrayList<>();
        int  currentEnd = arr[0].end;;

        for (int i =1 ;i< arr.length;i++){
            if (!(arr[i].start >= currentEnd)){
                return false;
            }
            currentEnd = arr[i].end;

        }
        return true;

    }

    public static void main(String[] args) {
        Intervals[] arr = {new Intervals(1, 4), new Intervals(2, 5), new Intervals(7, 9)};
        System.out.println(conflictingAppointments(arr));
        Intervals[] arr1 = {new Intervals(6, 7), new Intervals(2, 4), new Intervals(8, 12)};
        System.out.println(conflictingAppointments(arr1));
        Intervals[] arr2 = {new Intervals(4, 5), new Intervals(2, 3), new Intervals(3, 6)};
        System.out.println(conflictingAppointments(arr2));
    }
}
