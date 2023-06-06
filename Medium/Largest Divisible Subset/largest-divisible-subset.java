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
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int N, int[] arr) {
       Arrays.sort(arr); 
       int[] dp=new int[N];
       int[] hash=new int[N];
       
   
    
       for(int i=0;i<N;i++)
       {
           hash[i]=i;
           for(int j=0;j<i;j++)
           {
               if(arr[i]%arr[j]==0 && 1+dp[j]>dp[i])
               {
                   dp[i]=1+dp[j];
                   hash[i]=j;
               }
           }
           
           
       }
       int ans=0;  // we can also write ans=-1

        int last=0;// we can also write lastIndex=-1

        for(int i=0; i<N; i++)
        {

            if(dp[i]>ans){

                ans=dp[i];

                last=i;

            }

        }
       ArrayList<Integer>temp=new ArrayList<>();
       temp.add(arr[last]);
       while(hash[last]!=last)
       {
           last=hash[last];
           temp.add(arr[last]);
       }
       return temp;
    }
}
