class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        while(i<nums.length) {
            int correct = nums[i] -1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        for(int j=0; j< nums.length; j++) {
            if(j+1 != nums[j]) {
                list.add(j+1);
            }
        }
        return list;
        // In this approach i have used an extra space!
        // HashSet<Integer> set = new HashSet<>();
        // for(int i: nums) {
        //     set.add(i);
        // }
        // for(int i=1; i<= nums.length; i++) {
        //     if(!set.contains(i)) {
        //         list.add(i);
        //     }
        // }
        // return list;
    }
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}