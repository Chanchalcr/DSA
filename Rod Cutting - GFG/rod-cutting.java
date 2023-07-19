//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[] length = new int[n];
        for(int i = 1; i<= n; i++) {
            length[i-1] = i;
        }
        int[][] t = new int[n+1][n+1]; //size of array * n
        for(int i = 0; i <= n; i++) {
            t[i][0] = 0;
            t[0][i] = 0;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(length[i-1] <= j) {
                    t[i][j] = Math.max(t[i-1][j], price[i-1] + t[i][j - length[i-1]]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][n];
    }
}