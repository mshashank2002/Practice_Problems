class Solution {
    public boolean isPalindrome(int x)
    {
        int rem,revx=0,sample;
        sample=x;
        if(x<0)
        {
            return false;
        }
        while(sample!=0)
        {
            
            revx=revx*10+(sample%10);
            sample=sample/10;
        }
        if(revx==x)
            return true;
        else
            return false;
        
    }
}
