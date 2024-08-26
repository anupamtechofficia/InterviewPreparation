package CycleSort;

import java.util.*;

public class MissingNumber {

    public static int missingNumber(int arr[]){
        int i = 1;
        int result = 0;
        while (i <= arr.length){
            int temp = i-1;
            if(arr[temp] == 0){
                result = i;
                i++;
            } else if (arr[temp] != i){
                int temp2 = arr[arr[temp]-1];
                arr[arr[temp]-1] = arr[temp];
                arr[temp] = temp2;
            }else {
                if(arr[temp] == 0){
                }
                i++;
            }
        }
        return result;
    }
    public static int missingNumber1(int arr[]){
        int i = 0;
        while (i < arr.length){
            if(arr[i]!=i && arr[i]<arr.length){
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
            }else {
                i++;
            }
        }
        for (int j = 0 ;j < arr.length;j ++){
            if(arr[j ]!=j ){
                return j ;
            }
        }
        return arr.length;
    }

    public static List<Integer> missingAllNumber(int arr[]){
        int i = 0;
        while (i < arr.length){
            if(arr[arr[i]-1] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            }else {
                i++;
            }
        }
        List<Integer> missed = new ArrayList<>();
        int k = -1;
        for (int j = 0 ;j < arr.length;j ++){
            if(arr[j]!=(j+1) ){
                missed.add(j+1);
            }
        }
        return missed;
    }

    public static List<Integer> corruptPair(int arr[]){
        int i = 0;
        int duplicate = 0;
        List<Integer> pair = new ArrayList<>();
        while (i < arr.length){
            if(arr[arr[i]-1] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            }else {
            if(i!=(arr[i]-1)) {
                duplicate = arr[i];
            }
                i++;
            }
        }
        pair.add(duplicate);
        for (int j = 0 ;j < arr.length;j ++){
            if(arr[j]!=(j+1) ){
                pair.add(j+1);
                break;
            }
        }
        return pair;
    }

    public static int missingPositiveNumber(int arr[]){
        int i = 0;
        while (i < arr.length){
            if(arr[i]>0 && arr[i]<=arr.length && arr[arr[i]-1] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0 ;j < arr.length; j++){
            if(arr[j]!=(j+1) ){
                return j+1;
            }
        }
        return -1;
    }

    public static List<Integer> missingKPositiveNumber(int arr[], int k){
        List<Integer> pair = new ArrayList<>();
        Set<Integer> extra = new HashSet<>();

        int i = 0;
        while (i < arr.length){
            if (arr[i]>0) extra.add(arr[i]);
            if(arr[i]>0 && arr[i]<=arr.length && arr[arr[i]-1] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            } else {
                i++;
            }
        }
        int last = 0;
        for (int j = 0 ;j < arr.length; j++){
            if(arr[j]!=(j+1) ){
                pair.add(j+1);
                last = j+1;
            }
            if (pair.size()==k){
                break;
            }
        }
        while (pair.size()<k){
            if (!extra.contains(++last)){
                pair.add(last);
            }
        }
        return pair;
    }

    public static List<Integer> missingKPositiveNumber1(int arr[], int k){
        List<Integer> pair = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? 1:-1;
            }
        });
        for (int i=0;i<arr.length;i++){
            if(arr[i]>0){
                minHeap.add(arr[i]);
            }
        }
        int start = 1;
        while (!minHeap.isEmpty() && pair.size()<k){
            int currentMin = minHeap.peek();
            if (start<currentMin){
                pair.add(start);
                start++;
            } else {
                minHeap.poll();
                start = currentMin+1;
            }
        }
        while (pair.size()<k){
            pair.add(start);
            start++;
        }
        return pair;
    }

    public static int duplicate(int arr[]){
        int i = 0;
        while (i < arr.length){
            if(arr[arr[i]-1] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            }else if(i != (arr[i]-1)){
                return arr[i];
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, 3, 1};
        System.out.println(missingNumber1(arr));
        int[] arr1 = {8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println(missingNumber1(arr1));
        System.out.println("\n");
        int[] arr2 = {2, 4, 1, 2};
        missingAllNumber(arr2).forEach(a -> System.out.println(a));
        System.out.println("\n");
        int[] arr3 = {2, 3, 1, 8, 2, 3, 5, 1};
        missingAllNumber(arr3).forEach(a -> System.out.println(a));
        System.out.println("\n");
        int[] arr4 = {2, 3, 2, 1};
        missingAllNumber(arr4).forEach(a -> System.out.println(a));
        System.out.println("\n");
        int[] arr7 = {1, 4, 4, 3, 2};
        System.out.println(duplicate(arr7));
        int[] arr8 = {2, 1, 3, 3, 5, 4};
        System.out.println(duplicate(arr8));
        int[] arr9 = {2, 4, 1, 4, 4};
        System.out.println(duplicate(arr9));

        System.out.println("\ncorrupt");
        int[] pair1 = {3, 1, 2, 5, 2};
        corruptPair(pair1).forEach(a -> System.out.println(a));
        System.out.println("\n");
        int[] pair2 = {3, 1, 2, 3, 6, 4};
        corruptPair(pair2).forEach(a -> System.out.println(a));
        System.out.println("\n");

        System.out.println("\nmissingPositiveNumber\n");
        int[] posi1 = {-3, 1, 5, 4, 2};
        System.out.println(missingPositiveNumber(posi1));
        int[] posi2 = {3, -2, 0, 1, 2};
        System.out.println(missingPositiveNumber(posi2));
        int[] posi3 = {3, 2, 5, 1};
        System.out.println(missingPositiveNumber(posi3));
        System.out.println("\n");


        System.out.println("\nmissingKPositiveNumber\n");
        int[] kposi1 = {3, -1, 4, 5, 5};
        missingKPositiveNumber(kposi1, 3).forEach(a -> System.out.println(a));
        System.out.println("\n");
        int[] kposi2 = {2, 3, 4};
        missingKPositiveNumber(kposi2, 3).forEach(a -> System.out.println(a));
        System.out.println("\n");
        int[] kposi3 = {-2, -3, 4};
        missingKPositiveNumber(kposi3, 2).forEach(a -> System.out.println(a));


    }
}
