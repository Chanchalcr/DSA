// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        long sum = 0,maxSum=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<Arr.size()) {
            int size = (j-i)+1;
            if(size <= K) {
                sum += Arr.get(j);
                j++;
                maxSum = Math.max(maxSum,sum);
            } else {
                sum += Arr.get(j);
                j++;
                sum -= Arr.get(i);
                i++;
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
    } 
}