/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.*/

import java.util.*;
class Solution {
    public int singleNumber(int[] nums)
    {
        Arrays.sort(nums);
        int i;
        for(i=nums.length-1;i>0;i-=2)
        {
            if(nums[i]!=nums[i-1])
            {
                break;
            }
        }
        return nums[i];
        
    }
}
