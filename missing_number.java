/*Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.*/
class Solution {
    public int missingNumber(int[] nums) 
    {
        Arrays.sort(nums);
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=i)
            {
            
                break;
            }
           
        }
        return i;
        
    }
}
