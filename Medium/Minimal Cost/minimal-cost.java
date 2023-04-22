//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int N,int K)
    {
        int[] dp=new int[N+1];
        Arrays.fill(dp,-1);
        return solve(arr,N-1,dp,K);
        
       
    }
    
    public static int solve(int[]arr , int ind, int[] dp, int K)
    {
        if(ind==0)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int minStep=Integer.MAX_VALUE;
        for(int j=1;j<=K;j++)
        {
            if(ind-j>=0)
            {
                int jump=solve(arr,ind-j,dp,K)+Math.abs(arr[ind]-arr[ind-j]);
                minStep=Math.min(minStep,jump);
            }
        }
        return dp[ind]=minStep;
    }
}
