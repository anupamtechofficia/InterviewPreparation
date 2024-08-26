package PatternTwoPointers;

import java.util.Arrays;

public class SquaringASortedArray {

    public static int[] squaringASortedArray(int[] arr){
        int[] result = new int[arr.length];
        int start = 0;
        int end = arr.length-1;
        int index = end;
        while (start<=end){
            int startSq = arr[start]*arr[start];
            int endSq = arr[end]*arr[end];
             if(startSq>endSq){
                 result[index] = startSq;
                 start++;
             } else {
                 result[index] = endSq;
                 end--;
             }
            index--;

        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr ={-2, -1, 0, 2, 3};

        int[] result = squaringASortedArray(arr);
        Arrays.stream(result).forEach( x ->  System.out.println(x));
        int[] arr1 ={-3, -1, 0, 1, 2};
        int[] result1 = squaringASortedArray(arr1);
        Arrays.stream(result1).forEach( x ->  System.out.println(x));
    }
}
