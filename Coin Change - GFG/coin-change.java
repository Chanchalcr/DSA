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
    public long count(int coin[], int N, int sum) {
        long[][] t = new long[N+1][sum+1];
        t[0][0] = 1;
        for(int i = 1; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                if(coin[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i][j-coin[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][sum];
    }
}