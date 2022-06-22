class Solution { 
    
     public int triangleNumber(int[] nums) {
         Arrays.sort(nums);
         int left,right,count=0;
         for(int i=2;i<nums.length;i++) {
             right=i-1;
             left=0;
             while(left<right) {
                 if(nums[left]+nums[right] > nums[i]) {
                     count += right-left;
                     right--;
                 } else {
                     left++;
                 }
             }
         }
        return count;
     }
    
    //this approch uses the 3 nested loop hence the complexity is O(n^3)
    // public int triangleNumber(int[] nums) {
    //     int n = nums.length;
    //     int sum=0;
    //     int []tri = new int[3];
    //     if(n<3) return 0;
    //     for(int i=0; i< n-2; i++){
    //         for(int j=i+1; j< n-1; j++) {
    //             for(int k=j+1; k<n; k++) {
    //                 tri[0]=nums[i];
    //                 tri[1]=nums[j];
    //                 tri[2]=nums[k];
    //                 if(isTriangle(tri)) {
    //                     sum += 1;
    //                 }
    //             }
    //         }
    //     }
    //     return sum;
    // }
    // public static boolean isTriangle(int []tri) {
    //     if( tri[0]+tri[1] <= tri[2]) return false;
    //     if( tri[1]+tri[2] <= tri[0]) return false;
    //     if( tri[0]+tri[2] <= tri[1]) return false;
    //     if( tri[0] == 0 || tri[1] == 0 || tri[2] == 0) return false;
    //     return true;
    // }
    
}

























