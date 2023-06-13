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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static  int[][]dp;
   static boolean isPalindrome(String str, int start, int end){
    while(start<end){
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
}


static int solve(String str, int i, int j){
    
    if(i>=j){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    
    
  
    if(isPalindrome(str, i, j)){
        dp[i][j]=0;
        return 0;
    }
    
    
    int min = Integer.MAX_VALUE;
  
    for(int k = i; k<=j;k++){
        
      
        if(isPalindrome(str, i, k)){
            int partitions = 1+solve(str, k+1, j);
            min = Math.min(min, partitions);                
        }
        
        
    }
    
 
    dp[i][j]=min;
    return dp[i][j];
}
    static int palindromicPartition(String s)
    {
          dp = new int[s.length()][s.length()];
    for(int[]rows:dp)
    {
        Arrays.fill(rows,-1);
    }
    return solve(s, 0, s.length()-1);
    }
}