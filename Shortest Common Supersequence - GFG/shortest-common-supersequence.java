//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public static int shortestCommonSupersequence(String s1, String s2, int x, int y){
        int[][]dp = new int[x+1][y+1];
        for(int i=1; i<=x; ++i){
            for(int j=1; j<=y; ++j){
                char chx = s1.charAt(i-1);
                char chy = s2.charAt(j-1);
                if(chx==chy)
                dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                else
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        return x+y-dp[x][y];
    }
}