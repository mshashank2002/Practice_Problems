//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) 
    {
        long[][] dp=new long[N][sum+1];
        for(long[] rows:dp)
        {
            Arrays.fill(rows,-1);
        }
        return solve(N-1,sum,coins,dp);
        
    }
    
    static long solve(int ind,int sum,int[] arr, long[][]dp)
    {
        if(ind==0)
        {
            if(sum%arr[ind]==0)
            {
                return 1;
            }
            
            else
            {
                return 0;
            }
        }
        
        if(dp[ind][sum]!=-1)
        {
            return dp[ind][sum];
        }
        long nottake=solve(ind-1,sum,arr,dp);
        long take=0;
        if(arr[ind]<=sum)
        {
            take=solve(ind,sum-arr[ind],arr,dp);
        }
        
        return dp[ind][sum]=nottake+take;
    }
}