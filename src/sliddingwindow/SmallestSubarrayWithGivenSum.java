package sliddingwindow;

public class SmallestSubarrayWithGivenSum {

    public static int smallestSubarrayWithGivenSum(int[] arr, int k){
        int startWindow = 0;
        int endWindow = 0;
        int sum = 0;
        int result = arr.length;

        while (endWindow < arr.length) {
            sum += arr[endWindow];
            while ((sum - arr[startWindow]) >= k) {
                sum -= arr[startWindow];
                startWindow++;
                result = Math.min(result, endWindow - startWindow + 1);
            }
            endWindow++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr ={2, 1, 5, 2, 3, 2};

        System.out.println(smallestSubarrayWithGivenSum(arr, 7));
    }
}
