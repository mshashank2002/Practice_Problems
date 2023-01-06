//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int nums1[], int nums2[]) 
    {
        int s1=nums1.length;
        int s2=nums2.length;
        double[] temp=new double[n+m];
        int i=0,j=0,k=0;
        while(i<n&&j<m)
        {
            if(nums1[i]<=nums2[j])
            {
                temp[k]=nums1[i];
                i++;
                k++;
            }
            else
            {
                temp[k]=nums2[j];
                j++;
                k++;
            }
        }
        if(i>=n)
        {
            for(int t=j;t<m;t++)
            {
                temp[k]=nums2[t];
                k++;
            }
        }
        if(j>=m)
        {
            for(int t=i;t<n;t++)
            {
                temp[k]=nums1[t];
                k++;
            }
        }
        
        double ans=0.0;
        if(temp.length%2!=0)
            return temp[temp.length/2];
        else
            return (temp[temp.length/2]+temp[temp.length/2-1])/2;
    }
}