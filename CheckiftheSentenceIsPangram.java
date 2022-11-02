
    class Solution {
        public boolean checkIfPangram(String sentence)
        {
            int n=sentence.length();
            boolean answer=true;
            int[] a=new int[26];
            for(int i=0;i<n;i++)
            {
                int ch=(int)sentence.charAt(i);
                if(a[ch-97]==1)
                {
                    continue;
                }
                else
                {
                    a[ch-97]=1;
                }
            }
            for(int i=0;i<a.length;i++)
            {
                if(a[i]!=1)
                {
                    answer=false;
                }

            }
            return answer;
        }
    }
}
