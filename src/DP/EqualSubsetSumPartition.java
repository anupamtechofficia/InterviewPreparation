package DP;

public class EqualSubsetSumPartition {

    static boolean subsetPossible(int[] weight){
        int sum = 0;
        for (int i = 0;i< weight.length;i++){
            sum+= weight[i];
        }
        if(sum%2!=0) return  false;

        sum /=2;

        boolean[][] dp = new boolean[weight.length][sum+1];
        for (int i = 0;i< weight.length;i++){
            dp[i][0]=true;
        }

        for (int j = 1;j<= sum;j++){
            if(weight[0] == j){
                dp[0][j]=true;
            } else {
                dp[0][j]=false;
            }
        }
        for (int i = 1 ;i< weight.length;i++){
            for (int j = 1; j <= sum;j++){
                if(weight[i]>j){
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] == true ?true :  (dp[i-1][j-weight[i]]);
                }
            }
        }

        return dp[weight.length-1][sum];
    }

    static boolean subsetPossibleToK(int[] weight, int k){

        boolean[][] dp = new boolean[weight.length][k+1];
        for (int i = 0;i< weight.length;i++){
            dp[i][0]=true;
        }

        for (int j = 1;j<= k;j++){
            if(weight[0] == j){
                dp[0][j]=true;
            } else {
                dp[0][j]=false;
            }
        }
        for (int i = 1 ;i< weight.length;i++){
            for (int j = 1; j <= k;j++){
                if(weight[i]>j){
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] == true ?true :  (dp[i-1][j-weight[i]]);
                }
            }
        }

        return dp[weight.length-1][k];
    }

    public static void main(String ... s){
        int[] w = {1, 2, 3, 4 };
        System.out.println(subsetPossible(w));

        int[] p1 = {1, 1, 3, 4, 7};
        System.out.println(subsetPossible(p1));

        int[] p2 = {2, 3, 4, 6};
        System.out.println(subsetPossible(p2));

        int[] p3 = {1, 2, 3, 7};
        System.out.println(subsetPossibleToK(p3, 6));

        int[] p4 = {1, 2, 7, 1, 5};
        System.out.println(subsetPossibleToK(p4, 10));

        int[] p5 = {1, 3, 4, 8};
        System.out.println(subsetPossibleToK(p5, 6));
    }



}
