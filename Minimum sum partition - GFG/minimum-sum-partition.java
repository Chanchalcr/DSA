//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
	    int sum = 0, res = 0;
        for(int i : nums) {
            sum += i;
        }
        res = sum;
        for(int i = sum/2; i > 0; i--) {
            if(subset(nums, i)) {
                res = sum - (2*i);
                break;
            }
        }
        return res;
	}
	public boolean subset(int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length +1][sum+1];
        for(int i = 0; i < arr.length+1; i++) {
            t[i][0] = true;
        }
        for(int i = 1; i < t[0].length; i++) {
            t[0][i] = false;
        }

        for(int i = 1; i < t.length; i++) {
            for(int j = 1; j < t[0].length; j++) {
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}
