package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithOnesAfterReplacement {
    public static int sameLettersAfterReplacement(int[] input, int k){
        int startWindow = 0;
        int endWindow = 0;
        int result = 0;
        int newMax = 0;
        while (endWindow < input.length) {
            if(input[endWindow]==1) newMax++;
            while (((endWindow-startWindow+1)-newMax)>k) {
                if(input[startWindow]==1) newMax--;
                startWindow++;
            }
            result = Math.max(result, endWindow - startWindow + 1);
            endWindow++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(sameLettersAfterReplacement(arr, 2));
        int[] arr1 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};

        System.out.println(sameLettersAfterReplacement(arr1, 3));

    }
}
