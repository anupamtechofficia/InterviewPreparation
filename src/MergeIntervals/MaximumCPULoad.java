package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumCPULoad {

    public static class Intervals implements Comparable<Intervals>{
        public int start;
        public int end;

        public int load;


        Intervals(int start, int end, int load){
            this.start = start;
            this.end = end;
            this.load = load;
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

    public static int maximumCPULoad(Intervals[] arr){
        PriorityQueue<Intervals> minMeeting = new PriorityQueue<>(new EndTimeSort());

        Arrays.sort(arr);
        minMeeting.add(arr[0]);
        int maximumCPULoad = arr[0].load;
        int nextMeetingIndex = 1;
        int currentCPULoad = arr[0].load;
        while (nextMeetingIndex< arr.length){
            while (minMeeting.size()>0 && arr[nextMeetingIndex].start>= minMeeting.peek().end){
                currentCPULoad -=minMeeting.peek().load;
                minMeeting.poll();
            }
            minMeeting.add(arr[nextMeetingIndex]);
            currentCPULoad += arr[nextMeetingIndex].load;
            maximumCPULoad = Math.max(maximumCPULoad, currentCPULoad);
            nextMeetingIndex++;

        }
        return maximumCPULoad;

    }

    public static void main(String[] args) {
        Intervals[] arr = {new Intervals(1, 4, 3), new Intervals(2, 5, 4), new Intervals(7, 9, 6)};
        System.out.println(maximumCPULoad(arr));
        Intervals[] arr1 = {new Intervals(6, 7, 10), new Intervals(2, 4, 11), new Intervals(8, 12, 15)};
        System.out.println(maximumCPULoad(arr1));
        Intervals[] arr2 = {new Intervals(1, 4, 2), new Intervals(2, 4,    1), new Intervals(3, 6, 5)};
        System.out.println(maximumCPULoad(arr2));
    }
}
