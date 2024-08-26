package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class OrderAgnosticBinarySearch {

    public static int orderAgnosticBinarySearch(int arr[], int k){
        boolean isIncOrder = false;
        if(arr[arr.length-1]> arr[0]){
            isIncOrder = true;
        }
        int i = 0;
        int j = arr.length-1;
        while (i<=j){
            int mid = (i + j)/2;
            if(arr[mid] == k){
                return mid;
            }
            if((k> arr[mid] && isIncOrder) || (k < arr[mid] && !isIncOrder)){
                i = mid+1;
            } else {
                j = mid -1;
            }
        }
        return -1;
    }

    public static int maxInBitonicArray(int arr[]){
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            int mid = (i+j)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]>=arr[i]){
                i = mid+1;
            } else if(arr[mid]<arr[i]){
                j = mid-1;
            }
        }
        return arr[i];
    }
    public static int maxInBitonicArray1(int arr[]){
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            int mid = (i+j)/2;
            if(arr[mid]>arr[mid+1]){
                j = mid;
            } else {
                i = mid+1;
            }
        }
        return arr[i];
    }

    public static int rotateArray(int arr[], int k){
        int i = 0;
        int j = arr.length-1;
        while (i<=j){
            int mid = (i+j)/2;
            if (arr[mid] == k) return mid;
            if(arr[i] < arr[mid]){
                if(k<arr[mid] && k>=arr[i]){
                    j = mid-1;
                }else {
                    i = mid+1;
                }
            }else {
                if(k>arr[mid] && k<=arr[j]){
                    i = mid+1;
                } else {
                    j = mid-1;
                }
            }
        }
        return -1;
    }

    public static int rotateCount(int arr[]){
        if(arr[0] < arr[arr.length-1]) return 0;
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            int mid = (i+j)/2;
            if(arr[mid] >= arr[i]){
                i = mid+1;
            }else {
                j = mid;
            }
        }
        return i;
    }

    public static int minDiff(int arr[], int k){
        int i = 0;
        int j = arr.length-1;
        while (i<=j){
            int mid = (i+j)/2;
            if(arr[mid] == k){
                return arr[mid];
            }if(arr[mid]<k){
                i = mid+1;
            } else if(arr[mid]>k){
                j = mid-1;
            }
        }
        if(i< arr.length && arr[i] - k < k - arr[j] ){
            return arr[i];
        }
        return arr[j];
    }


    public static int ceiling(int arr[], int k){
        if(arr[arr.length-1]<k){
            return -1;
        }
        int i = 0;
        int j = arr.length-1;
        while (i<=j){
            int mid = (i + j)/2;
            if(arr[mid] == k){
                return mid;
            }
            if((k> arr[mid])){
                i = mid+1;
            } else {
                j = mid -1;
            }
        }
        return i;
    }

    public static List<Integer> range(int arr[], int k){
        List<Integer> res = new ArrayList<>(2);
        res.add(range1(arr, k, false));
        if(res.get(0) !=-1){
            res.add(range1(arr, k, true));
        } else {
            res.add(-1);
        }
        return res;
    }

    public static Integer range1(int arr[], int k, boolean findRightMax){
        int i = 0;
        int j = arr.length-1;
        int foundIndex = -1;
        while (i<=j) {
            int mid = (i + j) / 2;
            if (arr[mid] == k) {
                foundIndex = mid;
                if(findRightMax){
                    i = mid +1;
                } else {
                    j= mid -1;
                }
            } else  if ((k > arr[mid])) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return foundIndex;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 10};
        System.out.println(orderAgnosticBinarySearch(arr, 10));
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(orderAgnosticBinarySearch(arr1, 5));
        int[] arr2 = {10, 6, 4};
        System.out.println(orderAgnosticBinarySearch(arr2, 10));
        int[] arr3 = {4, 6, 10};
        System.out.println(ceiling(arr3, 6));
        int[] arr4 = {1, 3, 8, 10, 15};
        System.out.println(ceiling(arr4, 12));
        int[] arr5 = {4, 6, 10};
        System.out.println(ceiling(arr5, 17));
        int[] arr6 = {4, 6, 10};
        System.out.println(ceiling(arr6, -1));
        int[] arr7 = {4, 6, 6, 6, 9};
        System.out.println(range( arr7, 6));
        int[] arr8 = {1, 3, 8, 10, 15};
        System.out.println(range( arr8, 10));
        int[] arr9 = {1, 3, 8, 10, 15};
        System.out.println(range( arr9, 12));
        int[] arr10 = {1, 3, 8, 12, 4, 2};
        System.out.println(maxInBitonicArray1( arr10));
        int[] arr11 = {3, 8, 3, 1};
        System.out.println(maxInBitonicArray1(arr11));
        int[] arr12 = {1, 3, 8, 12};
        System.out.println(maxInBitonicArray1( arr12));
        int[] arr13 = {12, 8, 3, 1};
        System.out.println(maxInBitonicArray1( arr13));

        int[] arr14 = {4, 6, 10};
        System.out.println(minDiff( arr14, 7));
        int[] arr15 = {4, 6, 10};
        System.out.println(minDiff( arr15, 4));
        int[] arr16 = {1, 3, 8, 10, 15};
        System.out.println(minDiff( arr16, 12));
        int[] arr17 = {4, 6, 10};
        System.out.println(minDiff( arr17, 17));


        int[] arr18 = {10, 15, 1, 3, 8};
        System.out.println(rotateArray( arr18, 15));


        int[] arr19 = {10, 15, 1, 3, 8};
        System.out.println(rotateCount( arr19));

        int[] arr20 = {4, 5, 7, 9, 10, -1, 2};
        System.out.println(rotateCount( arr20));

        int[] arr21 = {1, 3, 8, 10};
        System.out.println(rotateCount( arr21));
    }
}
