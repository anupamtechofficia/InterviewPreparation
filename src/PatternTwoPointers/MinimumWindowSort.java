package PatternTwoPointers;

public class MinimumWindowSort {

    public static int minimumWindowSort(int[] arr){
        int[] minArray = new int[arr.length];
        int[] maxArray = new int[arr.length];
        minArray[0] = arr[0];
        maxArray[arr.length-1] = arr[arr.length-1];
        for (int i  = 1 ;i < arr.length ; i++){
            minArray[i] = Math.max(arr[i], minArray[i-1]);
            maxArray[arr.length-1-i] = Math.min(arr[arr.length-i], minArray[arr.length-1-i]);
        }
        int startIndex = 0;
        int endIndex = -1;
        for (int i = 0 ;i< arr.length;i++){
            if(minArray[i]!=maxArray[i]){
                startIndex = i;
                break;
            }
        }
        for (int i = arr.length-1 ;i>0;i--){
            if(minArray[i]!=maxArray[i]){
                endIndex = i;
                break;
            }
        }
        return endIndex - startIndex +1;

    }

    public static void main(String[] args) {
        int[] arr ={1, 2, 5, 3, 7, 10, 9, 12};
        System.out.println(minimumWindowSort(arr));
        int[] arr1 ={1, 3, 2, 0, -1, 7, 10};
        System.out.println(minimumWindowSort(arr1));
        int[] arr2 ={1, 2, 3};
        System.out.println(minimumWindowSort(arr2));
        int[] arr3 ={3, 2, 1};
        System.out.println(minimumWindowSort(arr3));

    }
}
