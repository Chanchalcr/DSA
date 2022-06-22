// { Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}// } Driver Code Ends



// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
    //this approach uses 0(n^2) complexity
    //   ArrayList<Integer> al = new ArrayList<>();
    //   for(int i=0;i<m;i++) {
    //       int count=0;
    //       for(int j=0;j<n;j++) {
    //           if(arr2[j] <= arr1[i]){
    //               count +=1;
    //           }
    //       }
    //       al.add(count);
    //   }
    //   return al;
       

       // add your code here
       ArrayList<Integer> ar = new ArrayList<>();
       Arrays.sort(arr2);
       
       for (int i=0; i<m; i++)
       {
          int count = binarySearch(arr1[i], arr2);
          ar.add(count);
       }
       return ar;
       
    }
    public static int binarySearch(int key, int[] arr)
    {
        int low =0, high=arr.length-1;
        int cs =0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if (arr[mid]<=key)
            {
                cs+=mid-low+1;
                low =mid+1;
            }
            else
            {
                high= mid-1;
            }
            
        }
        return cs;
    }
}