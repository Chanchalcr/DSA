//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] != 1 || A[X][Y] != 1) return -1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        boolean[][] vis = new boolean[N][M];
        vis[0][0] = true;
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        int res = -1;
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            while(size-- > 0) {
                Pair temp = q.poll();
                // System.out.println(temp.x + " " + temp.y);
                if(temp.x == X && temp.y == Y) return res;
                for(int[] dir : dirs) {
                    if(valid(A, temp.x+dir[0], temp.y+dir[1]) && !vis[temp.x+dir[0]][temp.y+dir[1]]) {
                        q.offer(new Pair(temp.x+dir[0], temp.y+dir[1]));
                        vis[temp.x+dir[0]][temp.y+dir[1]] = true;
                    }
                }
            }
        }
        return -1;
    }
    public boolean valid(int[][] A, int i, int j) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1) return false;
        return true;
    }
}