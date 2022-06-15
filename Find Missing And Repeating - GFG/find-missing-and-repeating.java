// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    // int[] findTwoElement(int arr[], int n) {
        
    //     int []ans =new int[2];
    //     int x=0,y=0,sum1=0,sum2=0;
    //     sum1 = (n*(n+1))/2;
        
    //     //finding number that occurs two times(y) with the help of hashSet
    //     HashSet<Integer> hs = new HashSet<>();
    //     for(int i=0; i<n; i++) {
    //         if(!hs.add(arr[i])) y=arr[i];
    //     }
        
    //     //find the actual sum of the array
    //     for(int i=0; i<n; i++){
    //         sum2 += arr[i];
    //     }
    //     //finding number that did not occur using formual sum2=sum1-x+y
    //     x = sum1+y-sum2;
        
    //     //adding the two numbers to the ans array and returing the array
    //     ans[0]=y;
    //     ans[1]=x;
    //     return ans;
    // }
    int[] findTwoElement(int arr[], int n) {
        // code here
                int[] res=new int[2];
        for (int i=0;i<n;i++){
            if (arr[Math.abs(arr[i])-1]<0){
                res[0]=Math.abs(arr[i]);
            }else {
                arr[Math.abs(arr[i])-1]=-arr[Math.abs(arr[i])-1];
            }
        }
        for (int i=0;i<n;i++){
            if (arr[i]>0){
                res[1]=i+1;
            }
        }
        return res;
    }
}