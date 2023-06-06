//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
  class SortbyLen implements Comparator<String> { 
    public int compare(String a, String b) 
    { 
        return a.length() - b.length(); 
    } 
} 


    public int longestChain(int N, String arr[]){
        Arrays.sort(arr, new SortbyLen()); 
        int n = arr.length;
        int[] dp = new int[n];
        int maxi = 1;
        Arrays.fill(dp , 1);
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(compare(arr[i] , arr[j]) && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            if(dp[i] > maxi)
                maxi = dp[i];
        }
        return maxi;  
    }
    
    boolean compare(String s1 , String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        
        if(l1 != l2+1)
            return false;
        
        int f = 0;
        int s = 0;
        while(f < l1)
        {
            if(s < l2 && s1.charAt(f) == s2.charAt(s)){
                f = f+1;
                s = s+1;
            }
            else
                f = f+1;
        }
        
        if(f == l1 && s == l2)
            return true;
        
        return false;
    }
}

