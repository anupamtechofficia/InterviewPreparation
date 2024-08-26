package PatternTwoPointers;

public class PairWithTargetSum {

    public static int[] pairWithTargetSum(int[] arr, int k){
        int[] result = new int[2];
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            if(arr[i]+arr[j]==k){
                result[0] = i;
                result[1] = j;
                return result;
            } else if(arr[i]+arr[j]>k){
                j--;
            } else {
                i++;
            }
        }


        return result;

    }

    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 6};
       int[] result = pairWithTargetSum(arr, 6);
        System.out.println(result[0] + " " + result[1]);
        int[] arr1 ={2, 5, 9, 11};
        int[] result1 = pairWithTargetSum(arr1, 11);
        System.out.println(result1[0] + " " + result1[1]);
    }
}
