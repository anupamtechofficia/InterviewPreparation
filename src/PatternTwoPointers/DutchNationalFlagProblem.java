package PatternTwoPointers;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    public static int[] dutchNationalFlagProblem(int[] input){
        int low = 0;
        int mid = 0;
        int high = input.length-1;

        while (mid<=high){
            switch (input[mid]){
                case 0: {
                    input[mid] = input[low];
                    input[low] = 0;
                    low++;
                    mid++;
                }break;
                case 2:{
                    input[mid] = input[high];
                    input[high] = 2;
                    high--;
                }
                break;
                default: {
                    mid++;
                }

            }

        }
        return input;

    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        Arrays.stream(dutchNationalFlagProblem(arr)).forEach(x -> System.out.println(x));
        System.out.println();
        int[] arr1 = {2, 2, 0, 1, 2, 0};

        Arrays.stream(dutchNationalFlagProblem(arr1)).forEach(x -> System.out.println(x));
    }
}
