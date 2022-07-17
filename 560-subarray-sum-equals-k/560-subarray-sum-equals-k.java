// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         int currentSum =0;
//         int count =0;
//         for (int i = 0; i < nums.length; i++) {
//             currentSum += nums[i];
//             if(currentSum == k) {
//                 count++;
//             }
//             if(hm.containsKey(currentSum-k)) {
//                 count++;
//             }
//             hm.put(currentSum,i);
//         }
//         return count;
//     }
// }
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
      
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}