package PatternTwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {

    public static int tripletSumCloseToTarget(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minSUM = arr[0]+arr[1]+arr[2];
        for (int third = arr.length-1; third>1;third--){
            int first = 0;
            int second = third-1;
            while (first<second){
                if(Math.abs(minSUM - target) >  Math.abs(arr[first] + arr[second] + arr[third] - target)){
                    minSUM = arr[first] + arr[second] + arr[third];
                }
               if ((arr[first] + arr[second] + arr[third])> target){
                    second--;
                } else {
                    first++;
                }
            }
        }


        return minSUM;

    }

    public static void main(String[] args) {
        int[] arr ={-2, 0, 1, 2};
        System.out.println(tripletSumCloseToTarget(arr, 2));
        int[] arr1 ={-3, -1, 1, 2};
        System.out.println(tripletSumCloseToTarget(arr1, 1));
        int[] arr2 ={1, 0, 1, 1};
        System.out.println(tripletSumCloseToTarget(arr2, 100));
    }
}
