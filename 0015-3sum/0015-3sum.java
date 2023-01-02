class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        
        for(int i=0;i<nums.length-2;i++)
        {
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                }
                else if(sum>0)
                {
                    k--;
                }
                else if(sum<0)
                {
                    j++;
                }
            }
            
            
                

        }
        return new ArrayList<>(ans);
    }
}