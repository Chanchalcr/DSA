//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        int maxSum = 0;
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        for(int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for(int j = 0; j < matrix.length; j++) {
                sum += matrix[j][i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        for(int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            res += maxSum-sum;
        }
        return res;
    }
}
        
