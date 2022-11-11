class Solution {
    public boolean isPalindrome(String s)
    {
         s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int n=s.length();
        char [] a = new char[n];
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=' '|| s.charAt(i)!=','||s.charAt(i)!=':')
            {
                a[i]=s.charAt(i);
            }
        }

        int i=0;
        int j=n-1;
        while(i<j)
        {
            if(a[i]!=a[j])
            {
                return false;
            }
            i++;
            j--;
            
        }
      return true;  
    }
}