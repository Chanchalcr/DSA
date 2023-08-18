//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int s)
    {
        int curr = a[0];
        int size = 1;
        for(int i = 1; i < a.length; i++) {
            if(a[i] == curr) {
                size++;
            }else {
                size--;
                if(size < 0) {
                    curr = a[i];
                    size = 1;
                }
            }
        }
        size = 0;
        for(int i : a) {
            if(i == curr) {
                size++;
            }
        }
        if(size > s/2) return curr;
        return -1;
    }
}