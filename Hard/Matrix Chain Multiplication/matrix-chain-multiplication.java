//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
          
    int [][] dp=new int[N][N];
    for(int row[]: dp)
    Arrays.fill(row,-1);
    
    for(int i=1; i<N; i++){
        dp[i][i] = 0;
    }
    
    for(int i=N-1; i>=1; i--){
        
        for(int j=i+1; j<N; j++){
            
            int mini = Integer.MAX_VALUE;
    
            // partioning loop
            for(int k = i; k<= j-1; k++){
                
                int ans = dp[i][k]+ dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                
                mini = Math.min(mini,ans);
                
            }
            
            dp[i][j] = mini;
    
        }
    }
    
    return dp[1][N-1];
    
}

}