//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String s1, String s2) { 
	  
	  int x= s1.length(), y = s2.length();
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
        
        return x + y - 2*dp[x][y];  
	} 
}