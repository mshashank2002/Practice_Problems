class Solution {
    public int maxProfit(int[] prices) 
    {
        int minimum=Integer.MAX_VALUE,maxprofit=0;
        for(int i=0;i<prices.length;i++)
        {
            
                if(prices[i]<minimum)
                {
                    minimum=prices[i];
                }
                maxprofit=Math.max(maxprofit,prices[i]-minimum);
            
        }
        return maxprofit;
        
    }
}