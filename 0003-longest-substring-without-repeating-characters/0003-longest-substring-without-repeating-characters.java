class Solution {
    public int lengthOfLongestSubstring(String s) {
        int p1=-1, p2=-1, currentSize = 0, maxSize = 0;
        HashSet<Character> set = new HashSet<>();
        
        while(p1<s.length()-1) {
            p1++;
            if(set.add(s.charAt(p1))) {
                currentSize++;
                if(maxSize <= currentSize) maxSize = currentSize;
            } else {
                set.remove(s.charAt(++p2));
                currentSize--;
                p1--;
            }  
        }
        return maxSize;
    }
}