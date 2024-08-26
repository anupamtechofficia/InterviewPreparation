package DP;

public class Knapsack {


    static int maxProfile(int[] weight, int[] power, int capacity){
        int[][] dp = new int[weight.length][capacity];
        for(int i = 1;i<=capacity;i++){
            if(i<weight[0]){
                dp[0][i-1] = 0;
            } else {
                dp[0][i-1] = power[0];
            }
        }
        for (int i = 1;i<weight.length;i++){
            for (int j = 1 ;j<=capacity;j++){
                if(j<weight[i]){
                    dp[i][j-1] =    dp[i-1][j-1];
                } else if(j==weight[i]){
                    dp[i][j-1] = Math.max( dp[i-1][j-1], power[i]);
                } else {
                    dp[i][j-1] = Math.max(dp[i-1][j-1], power[i]+dp[i-1][j-weight[i]-1]);
                }
            }
        }

        return dp[weight.length-1][capacity-1];
    }

    public static void main(String ... s){
        int[] w = {2, 3, 1, 4 };
        int[] p = {4, 5, 3, 7 };

        System.out.println(maxProfile(w,p,5));

        int[] p1 = {1, 6, 10, 16};
        int[] w1 = {1, 2, 3, 5};

        System.out.println(maxProfile(w1,p1,7));
        System.out.println(maxProfile(w1,p1,6));

    }
}
