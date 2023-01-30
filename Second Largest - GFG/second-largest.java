//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        // code here
        if(n == 1) return -1;
        int i, j;
        if(arr[0] > arr[1]) {
            j =0;
            i =1;
        } else if(arr[0] < arr[1]){
            j=1;
            i=0;
        } else {
            j = 1;
            i = 0;
        }
        int curr = 2;
        while(curr < arr.length) {
            if(arr[curr] > arr[j]) {
                i = j;
                j = curr;
            } else if(arr[curr] < arr[j] && (arr[curr] > arr[i] || arr[i] == arr[j])){
                i = curr;
            } else {
                
            }
            curr ++;
        }
        if(arr[i] == arr[j])
            return -1;
        return arr[i];
    }
}