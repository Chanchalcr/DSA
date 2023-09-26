//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();
        if(nums.length < 4) return finalAns;
        Arrays.sort(nums);
        
        for(int i =0; i< nums.length-3; i++) {
            
            if(i != 0 && nums[i-1] == nums[i]) continue;
            for(int j = i+1; j<nums.length-2; j++) {
                
                if(j != i+1 && nums[j-1] == nums[j]) continue;
                int tar = target - nums[j] - nums[i];
                int start = j+1, end = nums.length-1;
                
                while(start < end) {
                    ArrayList<Integer> list = new ArrayList<>();
                    if(start != j+1 && nums[start-1] == nums[start]) {
                        start++;
                        continue;
                    }
                    int sum = nums[start] + nums[end];
                    if((long)nums[i] + (long)nums[j] + (long)nums[start] + (long)nums[end] >Integer.MAX_VALUE ||(long)nums[i] + (long)nums[j] + (long)nums[start] + (long)nums[end] <Integer.MIN_VALUE) {
                        start++;end--;
                        continue;
                    }
                    if(sum == tar) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        finalAns.add(list);
                        start++;
                        end--;
                    }else if(sum < tar) {
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }
        return finalAns;
    }
}