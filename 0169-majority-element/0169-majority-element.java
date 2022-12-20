class Solution {
    public int majorityElement(int[] nums) 
    {
        int ansindex=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==nums[ansindex])
            {
                count++;
                
            }
            
            else
            {
                count--;
            }
            if(count<=0)
            {
                ansindex=i;
                count=1;
            }
        }
        int count1=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==nums[ansindex])
            {
                count1++;
            }
        }
        int element=nums[ansindex];
        if(count==count1)
        {
            element=nums[ansindex];
        }
        return element;
    }
}