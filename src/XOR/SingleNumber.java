package XOR;

import java.util.List;

public class SingleNumber {


    public static int singleNumber(int arr[]){
        int result = arr[0];
        int i = 1;
        while (i<arr.length){
            result = result ^ arr[i];
            i++;
        }
        return result;
    }

    public static int compliment(int number){
        int totalBit = 0;
        int temp = number;
        while (temp!=0){
            totalBit++;
            temp = temp >> 1;
        }
        int complementNumber = (int)Math.pow(2, totalBit) -1;


        return number ^ complementNumber;
    }


    public static List<Integer> doubleSingleNumber(int arr[]){
        int result = arr[0];
        int i = 1;
        while (i<arr.length){
            result = result ^ arr[i];
            i++;
        }
        int divider = 1;
        int res = divider & result;

        while (res != divider){
            divider = divider << 1;
            res = divider & result;
        }
        int result1 = 0;
        int result2 = 0;
        for (int j = 0 ;j< arr.length;j++){
            if((arr[j] & divider) == divider){
                result1 ^=arr[j];
            }else {
                result2 ^=arr[j];
            }
        }

        return List.of(result1, result2);
    }

    public static void main(String[] args) {
        int[] test1 = {1, 4, 2, 1, 3, 5, 6, 2, 3, 5, 2};
        System.out.println(singleNumber(test1));
        int[] test2 = {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        System.out.println(doubleSingleNumber(test2));
        System.out.println(compliment(8));
        System.out.println(compliment(10));
    }
}
