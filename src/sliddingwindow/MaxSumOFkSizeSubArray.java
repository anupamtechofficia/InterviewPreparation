package sliddingwindow;

public class MaxSumOFkSizeSubArray {

   public static int maxSumOFkSizeSubArray(int[] arr, int k){

       int sum= 0;
       if(k > arr.length){
           return -1;
       }

       for(int i = 0; i< k ;i++){
           sum+=arr[i];
       }
       int newsum = sum;
       for(int i = k ;i< arr.length;i++){
           newsum = newsum - arr[i-k]+arr[i];
           sum = Math.max(sum, newsum);
       }


       return sum;

    }

    public static void main(String[] args) {
       int[] arr ={2, 1, 5, 1, 3, 2};

       System.out.println(maxSumOFkSizeSubArray(arr, 3));
    }

}
