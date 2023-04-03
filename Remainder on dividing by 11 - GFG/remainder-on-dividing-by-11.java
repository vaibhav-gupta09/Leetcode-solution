//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
	{    
	    int odd = 0, even = 0;
	    for(int i=0; i<x.length(); ++i){
	        if(i%2==0)
	        even += x.charAt(i) - '0';
	        else
	        odd += x.charAt(i) - '0';
	    }
	    int val = ((odd-even)%11 + 11)%11;
	    return val;
	}
	
} 

