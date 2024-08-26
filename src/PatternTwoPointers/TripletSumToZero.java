package PatternTwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static List<List<Integer>> pairWithTargetSum(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int third = arr.length-1; third>1;third--){
            int first = 0;
            int second = third-1;
            while (first<second){
                if(arr[first] + arr[second]==-arr[third]){
                    result.add(List.of(arr[first], arr[second], arr[third]));
                    first++;
                    second--;
                } else if ((arr[first] + arr[second])>-arr[third]){
                   second--;
                } else {
                   first++;
                }
            }
        }


        return result;

    }

    public static void main(String[] args) {
        int[] arr ={-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = pairWithTargetSum(arr);
        result.stream().forEach(list -> System.out.println(list.toString()));
        int[] arr1 ={-5, 2, -1, -2, 3};
        List<List<Integer>> result1 = pairWithTargetSum(arr1);
        result1.stream().forEach(list -> System.out.println(list.toString()));
    }
}
