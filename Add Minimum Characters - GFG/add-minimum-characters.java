//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
	   int n = str.length();
	   StringBuilder sb = new StringBuilder(str);
	   sb.reverse();
	   str += sb.toString();
	   int[]lps = new int[str.length()];
	   
	   int i = 1, len = 0;
	   while(i<str.length()){
	      if(i==n) len = 0;
	      if(str.charAt(i) == str.charAt(len)){
	          len++;
	          lps[i++] = len;
	      }
	      else{
	          if(len>0) len = lps[len-1];
	          else lps[i++] = 0;
	      }
	   }
	   
	   return n - lps[str.length()-1];
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends