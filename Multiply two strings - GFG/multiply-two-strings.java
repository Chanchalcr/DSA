//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {   
        if(s1 == "0" || s2 == "0") return "0";
        
        boolean neg1 = false;
        boolean neg2 = false;
        int l1 = s1.length(), l2 = s2.length();
        
        if(s1.charAt(0) == '-'){
            neg1 = true;
        }
        
        if(s2.charAt(0) == '-'){
            neg2 = true;
        }
        
        int iLastIndex = 0;
        if(neg2){
            iLastIndex = 1;
            l2 -= 1;
        }
        
        int jLastIndex = 0;
        
        if(neg1){
            jLastIndex = 1;
            l1 -= 1;
        }
        
    
        int[] arr = new int[l1 + l2];
        
        int i = s2.length()-1;
        int pf = 0;
        while(i >= iLastIndex){
            int iVal = s2.charAt(i) - '0';
            int carry = 0;
            int k = arr.length - 1 - pf;
            int j=s1.length()-1;
            
            while(j >= jLastIndex || carry != 0){
                int jVal = j>=jLastIndex ? s1.charAt(j) - '0' : 0;
                
                int product = iVal * jVal + carry + arr[k];
                arr[k] = product % 10;
                carry = product/10;
                
                j--;
                k--;
            }
            i--;
            pf++;
        }
        
        String ans = "";
        if(neg1 || neg2){
            ans += '-';
        }
        
        if(neg1 && neg2){
            ans = "";
        }
        
        boolean flag = false; // for skipping the leading zeroes
        
        for(int l = 0; l<arr.length; l++){
            if(arr[l] != 0){
                flag = true;
            }
            
            if(flag){
                ans += arr[l];
            }
        }
        return ans;
    }
    
}