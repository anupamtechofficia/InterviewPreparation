package PatternTwoPointers;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr){
        int i = 1;
        int nextIndex = 1;
        while (i<arr.length){
            if(arr[nextIndex-1] != arr[i]){
                arr[nextIndex] = arr[i];
                nextIndex++;
            }
            i++;
        }

        return  nextIndex;

    }

    public static void main(String[] args) {
        int[] arr ={-2, -1, 0, 2, 3};
        System.out.println(removeDuplicates(arr));
        int[] arr1 ={2, 2, 2, 11};
        System.out.println(removeDuplicates(arr1));
    }
}
