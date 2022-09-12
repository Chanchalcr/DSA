class Solution {
    // public boolean isHappy(int n) {
    //     HashSet<Integer> set = new HashSet<>();
    //     while(true) {
    //         if(sumOfDigitSq(n) == 1) return true;
    //         if(set.add(sumOfDigitSq(n))) {
    //             n = sumOfDigitSq(n);
    //         } else {
    //             return false;
    //         }
    //     }
    // }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do{
            slow = sumOfDigitSq(slow);
            fast = sumOfDigitSq(sumOfDigitSq(fast));
        }while(slow != fast);
        
        if(slow == 1) {
            return true;
        }
        return false;
    }
    public static int sumOfDigitSq(int n){
        int sum=0;
        while(n!=0) {
            sum += Math.pow((n%10),2);
            n /= 10;
        }
        return sum;
    }
}