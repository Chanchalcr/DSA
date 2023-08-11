//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    long[][] dp;
    public long count(int coins[], int N, int amount){
        dp = new long[coins.length+1][amount + 1];
        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(amount, coins, coins.length-1, 0);
    }
    public long helper(int amount, int[] coins, int n, int sum) {
        if(n < 0) return 0;
        if(sum == amount) {
            dp[n][sum] = 1;
            return 1;
        }
        if(dp[n][sum] != -1) return dp[n][sum];
        if(coins[n] <= amount - sum) {
            long a = helper(amount, coins, n, sum + coins[n]);
            long b = helper(amount, coins, n-1, sum);
            dp[n][sum] = a+b;
            return a+b;
        }
        else {
            long a = helper(amount, coins, n-1, sum);
            dp[n][sum] = a;
            return a;
        } 
    }
}