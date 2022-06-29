class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 1)
            return 0;
        int mdiff=0,diff=0,min=prices[0],max=prices[0];
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1]>prices[i]){
                max=prices[i+1];
                diff=max-min;
                if(diff>mdiff)
                    mdiff=diff;    
            }
            else{
                if(prices[i+1]<min)
                    min=prices[i+1];
            }
        }
        
        return mdiff;
    }
}