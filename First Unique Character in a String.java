//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.


class Solution {
    public int firstUniqChar(String s)
    {
        int n=s.length();
        char c;
        for(int i=0;i<n;i++)
        {
            c=s.charAt(i);
            if(s.indexOf(c)==s.lastIndexOf(c))
            {
                return i;
            }
        }
        return -1;
       
    }
}
