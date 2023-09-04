//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<int[]> list = new ArrayList<>();
    static char[][] fill(int n, int m, char a[][])
    {
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 'O' && !vis[i][j]) {
                    list.clear();
                    dfs(a, i, j, vis);
                    if(!border(n, m)) {
                        for(int[] node : list) {
                            a[node[0]][node[1]] = 'X';
                        }
                    }
                }
            }
        }
        return a;
    }
    static void dfs(char a[][], int i, int j, boolean vis[][]) {
        list.add(new int[] {i, j});
        vis[i][j] = true;
        if(i > 0 && a[i-1][j] == 'O' && !vis[i-1][j]) {
            dfs(a, i-1, j, vis);
        }
        if(i < a.length-1 && a[i+1][j] == 'O' && !vis[i+1][j]) {
            dfs(a, i+1, j, vis);
        }
        if(j > 0 && a[i][j-1] == 'O' && !vis[i][j-1]) {
            dfs(a, i, j-1, vis);
        }
        if(j < a[0].length-1 && a[i][j+1] == 'O' && !vis[i][j+1]) {
            dfs(a, i, j+1, vis);
        }
    }
    static boolean border(int n, int m) {
        for(int[] node : list) {
            if(node[0] == 0 || node[0] == n-1 || node[1] == 0 || node[1] == m-1) {
                return true;
            }
        }
        return false;
    }
}