//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int maxProfit(int n, int[] prices) {
        
        int[][][] dp = new int[n + 1][2][3];
        
        
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    
                    int profit = Integer.MIN_VALUE;
                    if (buy == 1) {
                        // let's buy or don't want to buy
                        int take = -prices[ind] + dp[ind + 1][0][cap];
                        int notTake = 0 + dp[ind + 1][1][cap];

                        profit = Math.max(take, notTake);
                    }
                    else {
                        // let's sell or don't want to sell
                        int sell = prices[ind] + dp[ind + 1][1][cap - 1];
                        int notSell = 0 + dp[ind + 1][0][cap];

                        profit = Math.max(sell, notSell);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }
        
        return dp[0][1][2];
    }
}
        
