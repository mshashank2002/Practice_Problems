class Solution {
    public int maxSubArray(int[] nums)
    {
        int cursum=0,maxsum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            cursum+=nums[i];
            if(cursum>maxsum)
            {
                maxsum=cursum;
                
            }
            if(cursum<0)
            {
                cursum=0;
            }
        }
        return maxsum;
        
    }
}