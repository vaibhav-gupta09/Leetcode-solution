//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
	   int b = 0, a = 0;
	   
	   int idx = 0;
	   while(idx<str.length()){
	       char ch = str.charAt(idx);
	       if(ch=='a'){
	           idx++;
	           continue;
	       }
	       
	       while(idx<str.length() && str.charAt(idx)=='b') idx++;
	       b++;
	   }
	   idx = 0;
	   while(idx<str.length()){
	       char ch = str.charAt(idx);
	       if(ch=='b'){
	           idx++;
	           continue;
	       }
	       
	       while(idx<str.length() && str.charAt(idx)=='a') idx++;
	       a++;
	   }
	   
	   return Math.min(a,b)+1;
	}
}