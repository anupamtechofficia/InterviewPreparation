package DP;

public class SubsetSum {


    static int maxProfile(int[] set, int sum){
        int[][] dp = new int[set.length+1][sum+1];
        for (int i = 0;i<=set.length;i++){
            dp[i][0] = 1;
        }
        for (int i = 1;i<=sum;i++){
            dp[0][i] = 0;
        }

        for (int i = 1;i <=set.length;i++){
            for (int j = 1 ;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=set[i-1]){
                    dp[i][j] +=  dp[i-1][j-set[i-1]];
                }
            }
        }

        return dp[set.length][sum];
    }

    public static void main(String ... s){
        int[] w = {1, 1, 2, 3};
        System.out.println(maxProfile(w,4));

        int[] w1 = {1, 2, 7, 1, 5};
        System.out.println(maxProfile(w1,9));
    }
}
