class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        
        int[] pairs=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    pairs[0]=i;
                    pairs[1]=j;
                    break;
                }
            }
        }

        return pairs;
        
    }
}