//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][][] t;
    static int countWays(int N, String S){
        t=new int[N+1][N+1][2];
        for(int[][] two:t){
            for(int[] it:two)
            Arrays.fill(it,-1);
        }
        return solve(S.toCharArray(),0,N-1,true);
    }
    
    public static  int solve(char[] str,int i,int j,boolean isTrue){
        if(i>j) return 0;
        if(i==j){ if(isTrue) return str[i]=='T'?1:0; else return str[i]=='F'?1:0;  }
        char[] key=new char[]{(char)i,(char)j,isTrue==true?'T':'F'};
        if(t[i][j][isTrue==true?1:0]!=-1) return t[i][j][isTrue==true?1:0]%1003;
        int ans=0;
        for(int k=i+1;k<j;k=k+2){
            int leftTrue=t[i][k-1][1]!=-1?t[i][k-1][1]:solve(str,i,k-1,true);
            int leftFalse=t[i][k-1][0]!=-1?t[i][k-1][0]:solve(str,i,k-1,false);
            int rightTrue=t[k+1][j][1]!=-1?t[k+1][j][1]:solve(str,k+1,j,true);
            int rightFalse=t[k+1][j][0]!=-1?t[k+1][j][0]:solve(str,k+1,j,false);
            switch(str[k]){
                case '&':{ if(isTrue) ans+=leftTrue*rightTrue; else ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;break;}
                case '|':{ if(isTrue) ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftTrue*rightTrue; else ans+=leftFalse*rightFalse;break;}
                case '^':{ if(isTrue) ans+=leftTrue*rightFalse+leftFalse*rightTrue;else ans+=leftTrue*rightTrue+leftFalse*rightFalse;break;}
            }
        }
        ans%=1003;
        t[i][j][isTrue==true?1:0]=ans;
        return ans;
    }
}