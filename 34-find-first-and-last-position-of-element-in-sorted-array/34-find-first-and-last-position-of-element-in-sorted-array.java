//the naive attemp will be to use to linear search and complexity will be O(2n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[2];
        int f1=-1,f2=-1;
        int lo=0,hi=nums.length-1,mid;
        
        //to find the first occurance f1 use the binary search
        while (hi >= lo) {
            mid = (hi+lo)/2;
            if(nums[mid] == target) {
                f1 = mid;
                hi = mid-1;
            } else if(target < nums[mid]) {
                hi = mid-1;
            } else if(target > nums[mid]) {
                lo = mid+1;
            }
        }
        lo=0; hi=nums.length-1;
        //to find the second occurance f2 use other binary search
        while (hi >= lo) {
            mid = (hi+lo)/2;
            if(nums[mid] == target) {
                f2 = mid;
                lo = mid+1;
            } else if(target < nums[mid]) {
                hi = mid-1;
            } else if(target > nums[mid]) {
                lo = mid+1;
            }
        }
        ans[0]=f1;ans[1]=f2;
        return ans;
    }
}