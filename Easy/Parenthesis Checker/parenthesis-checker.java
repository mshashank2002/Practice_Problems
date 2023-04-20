//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> s=new Stack<>();
        int len=x.length();
        if(x.charAt(0)==')'||x.charAt(0)==']'||x.charAt(0)=='}')
        {
            return false;
        }
        
        if(len%2!=0)
        {
            return false;
        }
        for(int i=0;i<len;i++)
        {
            if(x.charAt(i)=='('||x.charAt(i)=='{'||x.charAt(i)=='[')
            {
                s.push(x.charAt(i));
            }
            else
            {
                if(!s.empty())
                {
                    if(x.charAt(i)==')'&&s.peek()=='('||x.charAt(i)==']'&&s.peek()=='['||x.charAt(i)=='}'&&s.peek()=='{')
                    {
                        s.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            
            
        }
        return true;
    }
}
