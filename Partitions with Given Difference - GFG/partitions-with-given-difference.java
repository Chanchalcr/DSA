//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int d, int arr[]){
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        if((d+sum) % 2 == 1) return 0;
        int sub = (d + sum)/2;
        return count(arr, sub);
    }
    public int count(int[] arr, int sum) {
        long[][] t = new long[arr.length +1][sum+1];
        t[0][0] = 1;
        for(int i = 1; i < t[0].length; i++) {
            t[0][i] = 0;
        }

        for(int i = 1; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                if(arr[i-1] <= j) {
                    t[i][j] = (t[i-1][j] + t[i-1][j-arr[i-1]])%1000000007;
                }else {
                    t[i][j] = t[i-1][j]%1000000007;
                }
            }
        }
        return (int)t[arr.length][sum]%1000000007;
    }
}