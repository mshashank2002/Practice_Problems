//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ public List<String> all_longest_common_subsequences(String s, String t)

    {

         List<String> list = new ArrayList<>();

        int[][] dp=  new int[s.length()+1][t.length()+1];

 

        for(int i=1;i<dp.length;i++){

            for(int j=1;j<=t.length();j++){

                if(s.charAt(i-1)==t.charAt(j-1)){

                    dp[i][j]=1+dp[i-1][j-1];

                }

                else{

                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);

                }

            }

        }

 

        int res = dp[dp.length-1][dp[0].length-1];

        HashSet<String> set = new HashSet<>();

        StringBuilder builder = new StringBuilder();

        rec(s,t,builder,0,0,set,res);

        list.addAll(set);

        Collections.sort(list);

        return list;

       

    }

    

    private  static void rec(String s, String t, StringBuilder builder, int i, int j, HashSet<String> set, int res) {

        if(res==0){

            set.add(builder+"");

            return;

        }

        for (int k = i; k <s.length() ; k++) {

            for (int l = j; l <t.length() ; l++) {

                if(s.charAt(k)==t.charAt(l)) {

                    builder.append(s.charAt(k));

                    rec(s,t,builder,k+1,l+1,set,res-1);

                    builder.deleteCharAt(builder.length()-1);

                }

            }

        }

    }
}