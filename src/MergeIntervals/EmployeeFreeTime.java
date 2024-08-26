package MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {


    public static class Intervals implements Comparable<Intervals> {
        public int start;
        public int end;

        public int index;

        public int employeIndex;


        Intervals(int start, int end, int index, int employeIndex) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.employeIndex = employeIndex;
        }

        @Override
        public int compareTo(Intervals o) {
            if (o.start == this.start) return 0;
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

    public static List<Intervals> employeeFreeTimeHeap(List<List<Intervals>> employeesWorkingTime) {
        PriorityQueue<Intervals> minHeap = new PriorityQueue<>();
        List<Intervals> result = new ArrayList<>();
        for (int i = 0; i < employeesWorkingTime.size(); i++) {
            minHeap.add(employeesWorkingTime.get(i).get(0));
        }
        Intervals currentInterval = minHeap.poll();;
        Intervals firstSmall = currentInterval;
        do {

            if(employeesWorkingTime.get(firstSmall.employeIndex).size()> (firstSmall.index+1)){
                minHeap.add(employeesWorkingTime.get(firstSmall.employeIndex).get(firstSmall.index+1));
            }

            Intervals nextSmall = minHeap.poll();
            if(currentInterval.end>=nextSmall.start){
                    currentInterval.end = Math.max(currentInterval.end , nextSmall.end);
            }else {
                result.add(new Intervals(currentInterval.end, nextSmall.start,0,0));
                currentInterval  = nextSmall;
            }
            firstSmall = nextSmall;
        } while (!minHeap.isEmpty());

        return result;

    }

    public static List<Intervals> employeeFreeTime(List<List<Intervals>> employeesWorkingTime) {
        List<Intervals> result = new ArrayList<>();
        boolean[] clock = new boolean[13];
        for (List<Intervals> employeeWorkingTime : employeesWorkingTime) {
            for (Intervals workingTime : employeeWorkingTime) {
                for (int i = workingTime.start; i <= workingTime.end; i++) {
                    if (i != workingTime.end) {
                        clock[i] = true;
                    }
                }
            }

        }
        int time = 1;
        int start = 1;
        while (time <= 13) {
            int end = start;
            while (time <= 12 && clock[time] == false) {
                end = ++time;
            }
            if (start != end && end != clock.length && start != 1) {
                result.add(new Intervals(start, end,0,0));
            }
            start = ++time;
        }
        return result;


    }

    public static void main(String[] args) {
        List<List<Intervals>> employeeWorkingTime = List.of(List.of(new Intervals(1, 3, 0, 0), new Intervals(5, 6,1, 0)),
                List.of(new Intervals(2, 3, 0, 1), new Intervals(6, 8, 1, 1)));
        System.out.println(employeeFreeTimeHeap(employeeWorkingTime).toString());
        List<List<Intervals>> employeeWorkingTime1 = List.of(
                List.of(new Intervals(1, 3, 0, 0), new Intervals(9, 12, 1, 0)),
                List.of(new Intervals(2, 4, 0, 1), new Intervals(6, 8, 1, 1)));
        System.out.println(employeeFreeTimeHeap(employeeWorkingTime1).toString());
        List<List<Intervals>> employeeWorkingTime2 = List.of(
                List.of(new Intervals(1, 3, 0, 0), new Intervals(2, 4, 1, 0)),
                List.of(new Intervals(3, 5, 0, 1)),
                List.of(new Intervals(3, 5, 0, 2)),
                List.of(new Intervals(7, 9, 0, 3))
        );
        System.out.println(employeeFreeTimeHeap(employeeWorkingTime2).toString());
    }
}
