//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            temp ^= nums[i];
        }
        int r = temp & ~(temp-1);
        int x = 0, y = 0;
        for(int i = 0; i< nums.length; i++) {
            if((nums[i]&r) == 0) {
                x ^= nums[i];
            }else {
                y ^= nums[i];
            }
        }
        int[] res = new int[2];
        if(x <= y) {
            res[0] = x;
            res[1] = y;
        }
        else {
            res[1] = x;
            res[0] = y;
        }
        return res;
    }
}