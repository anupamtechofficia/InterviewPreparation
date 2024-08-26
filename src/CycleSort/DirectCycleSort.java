package CycleSort;

import java.util.Arrays;

public class DirectCycleSort {

    public static void sort(int arr[]){
        int i = 1;
      while (i <= arr.length){
          int temp = i-1;
          if (arr[temp] != i){
              int temp2 = arr[arr[temp]-1];
              arr[arr[temp]-1] = arr[temp];
              arr[temp] = temp2;
          }else {
              i++;
          }
      }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        sort(arr);
        Arrays.stream(arr).forEach( a-> System.out.println(a));
        int[] arr1 = {2, 6, 4, 3, 1, 5};
        sort(arr1);
        Arrays.stream(arr).forEach( a-> System.out.println(a));
        int[] arr2 = {1, 5, 6, 4, 3, 2};
        sort(arr2);
        Arrays.stream(arr).forEach( a-> System.out.println(a));
    }
}
