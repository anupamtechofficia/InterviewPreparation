package MergeIntervals;

import java.util.*;

public class MinimumMeetingRooms {

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

    static class EndTimeSort implements Comparator<Intervals> {


        @Override
        public int compare(Intervals o1, Intervals o2) {
            if(o1.end<o2.end){
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static int minimumMeetingRooms(Intervals[] arr){
        Arrays.sort(arr);
        int minimumMeetingRooms = 1;
        int  currentEnd = arr[0].end;;

        for (int i =1 ;i< arr.length;i++){
            if (arr[i].start < currentEnd){
                currentEnd = Math.min(currentEnd, arr[i].end);
                minimumMeetingRooms++;
            }

        }
        return minimumMeetingRooms;

    }

    public static int minimumMeetingRooms1(Intervals[] arr){
        PriorityQueue<Intervals> minMeeting = new PriorityQueue<>(new EndTimeSort());

        Arrays.sort(arr);
        minMeeting.add(arr[0]);
        int minimumMeetingRooms = 1;
        int nextMeetingIndex = 1;
        while (nextMeetingIndex< arr.length){
            while (minMeeting.size()>0 && arr[nextMeetingIndex].start>= minMeeting.peek().end){
                minMeeting.poll();
            }
            minMeeting.add(arr[nextMeetingIndex]);
            minimumMeetingRooms = Math.max(minimumMeetingRooms, minMeeting.size());
            nextMeetingIndex++;

        }
        return minimumMeetingRooms;

    }

    public static void main(String[] args) {
        Intervals[] arr = {new Intervals(1, 4), new Intervals(2, 5), new Intervals(7, 9)};
        System.out.println(minimumMeetingRooms1(arr));
        Intervals[] arr1 = {new Intervals(6, 7), new Intervals(2, 4), new Intervals(8, 12)};
        System.out.println(minimumMeetingRooms1(arr1));
        Intervals[] arr2 = {new Intervals(1, 4), new Intervals(2, 3), new Intervals(3, 6)};
        System.out.println(minimumMeetingRooms1(arr2));
    }
}
