class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true) {
            if(sumOfDigit(n) == 1) return true;
            if(set.add(sumOfDigit(n))) {
                n = sumOfDigit(n);
            } else {
                return false;
            }
        }
    }
    public static int sumOfDigit(int n){
        int sum=0;
        while(n!=0) {
            sum += Math.pow((n%10),2);
            n /= 10;
        }
        return sum;
    }
}