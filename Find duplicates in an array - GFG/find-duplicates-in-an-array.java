// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        //this is correct solution with the use of a hashset!
        // ArrayList<Integer> al = new ArrayList<>();
        // HashSet<Integer> hs=new HashSet<>();
        // int i=0;boolean flag=false;
        // while(i<n){
        //     if(hs.contains(arr[i])){
        //         al.add(arr[i]);
        //         hs.remove(arr[i]);
        //         flag=true;
        //     }
        //     else{
        //         hs.add(arr[i]);
        //     }
        //     i++;
        // }
        // if(flag)
        // return al;
        // else{
        //     al.add(-1);
        //     return al;
        // }
        HashMap<Integer, Integer> occurance = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            occurance.put(arr[i], occurance.getOrDefault(arr[i], 0) + 1);
        }
        
        for (Map.Entry<Integer,Integer> entry : occurance.entrySet()) {
              if(entry.getValue() > 1){
                  result.add(entry.getKey());
              }
        }
        if(result.size() == 0){
            result.add(-1);
        }
        Collections.sort(result);
        return result;
    }
}
