//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int totalWays(int N, int M, int grid[][]) 
    {
        
        int[][] dp=new int[N+1][M+1];
        for(int [] rows: dp)
        {
            Arrays.fill(rows,-1);
        }
        return solve(grid,N-1,M-1,dp);
    }
    
    public static int solve(int[][] maze, int i, int j, int[][] dp)
    {
         int mod =1000000007;
       if(i>=0 && j>=0 && maze[i][j]==1)
       {
           return 0; 
       }
  if(i==0 && j == 0)
  {
    return 1;
  }
  if(i<0 || j<0)
  {
    return 0;
  }
  if(dp[i][j]!=-1) 
  {
      return dp[i][j];
  }
  int up = solve(maze,i-1,j,dp);
  int left = solve(maze,i,j-1,dp);
  
  return dp[i][j] = (up+left)%mod;
}
}