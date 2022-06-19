class Solution {
    public int search(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        // if(nums.length > 2){
        while(hi >= lo) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[lo] <= nums[mid]) {
                if( nums[lo] <= target && target < nums[mid]) {
                    hi = mid-1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if( nums[mid] < target && target <= nums[hi]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        
        // if(nums.length == 2) {
        //     if(nums[0] == target) return 0;
        //     else if(nums[1] == target) return 1;
        //     else return -1;
        // }
        // if(nums.length == 1){
        //     if(nums[0] == target) return 0;
        //     else return -1;
        // }
        return -1;
    }
}