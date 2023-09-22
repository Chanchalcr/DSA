//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = n -1;
        while(i <= j) {
            int mid = i + (j - i)/2;
            if(arr[mid] == x) {
                int l = i, r = mid;
                while(l < r) {
                    int m = l + (r - l)/2;
                    if(arr[m] == x) {
                        r = m;
                    }else l = m + 1;
                }
                list.add(r);
                l = mid; r = n-1;
                while(l <= r) {
                    int m = l + (r-l)/2;
                    if(arr[m] == x) {
                        l = m+1;
                    }else r = m-1;
                }
                list.add(l-1);
                break;
            }
            if(arr[mid] < x) {
                i = mid+1;
            }else {
                j = mid-1;
            }
        }
        if(list.isEmpty()) {
            list.add(-1);
            list.add(-1);
            return list;
        }
        return list;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends