/*There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity. */

class Solution {
    public int search(int[] nums, int target) 
    {
        int low=0,high=nums.length-1,mid;
        while(low<=high)
        {
            mid=(high+low)/2;
            if(target==nums[mid])
            {
                return mid;
            }

            if(nums[low]<=nums[mid])
            {
                if(target>=nums[low]&&target<=nums[mid])
                  {
                      high=mid-1;

                   }
                   else
                   {
                       low=mid+1;
                   }
            }
            else 
            {
                if(target<=nums[high]&&target>=nums[mid])
                {
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
        
    }
}


/*Method:
Binary search procedure is used. If tagert is equal to mid then return mid.Else see if left side of mid is sorted[nums[low]<=nums[mid]]And target is in left side perform as in binary search. Or else Check the same for right side .
*/
